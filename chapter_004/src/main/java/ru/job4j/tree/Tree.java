package ru.job4j.tree;

import java.util.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 13.07.2018
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int size = 0;
    private int modCount = 0;

    public Tree(E elem) {
        this.root = new Node<>(elem);
    }

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (!findBy(child).isPresent()) {
            findBy(parent).get().add(new Node<>(child));
            size++;
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node> findBy(E value) {
        Optional<Node> rsl = Optional.empty();
        Queue<Node> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        Queue<Node> queue = new LinkedList<>();
        boolean result = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
           Node node = queue.poll();
           if (node.leaves().size() > 2) {
               result = false;
               break;
           }
            for (Object child : node.leaves()) {
                queue.offer((Node) child);
            }
       }
        return result;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new NewIterator<>();
    }

    private class NewIterator<E> implements Iterator<E> {

        private Queue<Node> queue;
        private int expectedModCount = modCount;

        public NewIterator() {
            this.queue = new LinkedList<>();
            queue.add(root);
        }

        public void getChild(Node node) {
            for (Object n : node.leaves()
                    ) {
                queue.offer((Node) n);
            }
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node res = queue.poll();
            getChild(res);
            return (E) res.getValue();
        }
    }
}



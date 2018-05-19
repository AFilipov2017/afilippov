package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


import java.util.NoSuchElementException;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.2
 * @since 14.05.2018
 */
public class LinkedContainer<E> implements Iterable<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    private int modCount = 0;


    public LinkedContainer() {
        lastNode = new Node<>(null, null, firstNode);
        firstNode = new Node<>(null, lastNode, null);
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }

    public Node<E> getLastNode() {
        return lastNode;
    }

    public void add(E value) {
        Node<E> prev = lastNode;
        prev.setElement(value);
        lastNode = new Node<>(null, null, prev);
        prev.setNext(lastNode);
        modCount++;
        size++;
    }

    public void addFirst(E value) {
        Node<E> next = firstNode;
        next.setElement(value);
        firstNode = new Node<>(null, next, null);
        next.setPrev(firstNode);
        modCount++;
        size++;
    }

    public E get(int index) {
        Node<E> target = firstNode.getNext();
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target.getElement();
    }

    public E unlinkFirst(Node<E> f) {
        final E element = f.element;
        final Node<E> next = f.next;
        f.element = null;
        f.next = null;
        firstNode = next;
        if (next == null) {
            lastNode = null;
        } else {
            next.prev = null;
        }
        size--;
        modCount++;
        return element;
    }

    public E unlinkLast(Node<E> l) {
        final E element = l.element;
        final Node<E> prev = l.prev;
        l.element = null;
        l.prev = null;
        lastNode = prev;
        if (prev == null) {
            firstNode = null;
        } else {
            prev.next = null;
        }
        size--;
        modCount++;
        return element;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int pos = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return size > pos;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(pos++);
            }
        };
    }

    public class Node<E> {
        private E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}

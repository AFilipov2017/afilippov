package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
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

    public void add(E value) {
        Node<E> prev = lastNode;
        prev.setElement(value);
        lastNode = new Node<>(null, null, prev);
        prev.setNext(lastNode);
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

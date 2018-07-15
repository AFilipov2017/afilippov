package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 12.07.2018
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children;
    private final E value;

    public Node(final E value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public E getValue() {
        return value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

}

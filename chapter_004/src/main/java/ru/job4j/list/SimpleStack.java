package ru.job4j.list;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 19.05.2018
 */
public class SimpleStack<E> extends LinkedContainer<E> {
    public E poll() {
        final Node<E> l = getLastNode().prev;
        return (l == null) ? null : unlinkLast(l);
    }

    public void push(E value) {
        add(value);
    }
}

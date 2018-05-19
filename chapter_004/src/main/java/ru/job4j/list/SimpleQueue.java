package ru.job4j.list;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 19.05.2018
 */
public class SimpleQueue<E> extends LinkedContainer<E> {
    public E poll() {
        final Node<E> f = getFirstNode().next;
        return (f == null) ? null : unlinkFirst(f);
    }

    public void push(E value) {
        add(value);
    }
}

package ru.job4j.set;

import ru.job4j.list.LinkedContainer;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 23.05.2018
 */
public class LinkedSimpleSet<E> implements Iterable<E> {

    private LinkedContainer<E> link;

    public LinkedSimpleSet() {
        this.link = new LinkedContainer<>();
    }

    public void add(E e) {
        if (checkDuplicate(e)) {
            link.add(e);
        }
    }

    public boolean checkDuplicate(E e) {
        boolean result = true;
        for (Object o : link) {
            if (e.equals(o)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedSimpleSet<?> that = (LinkedSimpleSet<?>) o;
        return Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(link);
    }

    @Override
    public Iterator<E> iterator() {
        return link.iterator();
    }
}

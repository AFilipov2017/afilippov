package ru.job4j.set;

import ru.job4j.list.SimpleList;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 21.05.2018
 */
public class SimpleSet<E> implements Iterable<E> {

    public SimpleList<E> list;

    public SimpleSet() {
        this.list = new SimpleList<>();
    }

    public void add(E e) {
        if (checkDuplicate(e)) {
            list.add(e);
        }
    }

    public boolean checkDuplicate(E e) {
        boolean result = true;
        for (Object o : list) {
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
        SimpleSet<?> simpleSet = (SimpleSet<?>) o;
        return Objects.equals(list, simpleSet.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}

package ru.job4j.set;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 29.05.2018
 */
public class SimpleHashSet<E> implements Iterable<E> {

    private SimpleHashTable<E> hashTable;

    public SimpleHashSet() {
        this.hashTable = new SimpleHashTable<>();
    }

    public boolean add(E e) {
        boolean result = false;
        if (checkDuplicate(e)) {
            hashTable.add(e);
            result = true;
        }
        return result;
    }

    public boolean contains(E e) {
        return hashTable.contains(e);
    }

    public boolean remove(E e) {
        return hashTable.remove(e);
    }

    public boolean checkDuplicate(E e) {
        boolean result = true;
        for (Object o : hashTable) {
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
        SimpleHashSet<?> that = (SimpleHashSet<?>) o;
        return Objects.equals(hashTable, that.hashTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashTable);
    }

    @Override
    public Iterator<E> iterator() {
        return hashTable.iterator();
    }
}

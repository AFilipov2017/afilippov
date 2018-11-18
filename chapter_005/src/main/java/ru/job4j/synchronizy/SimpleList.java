package ru.job4j.synchronizy;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 18.11.2018
 */
public class SimpleList<E> implements Iterable<E> {
    private Object[] array;
    private int position = 0;
    private int defaultSize = 10;
    private int modCount = 0;

    public SimpleList() {
        this.array = new Object[defaultSize];
    }

    public void add(E value) {
        checkTheSizeArray();
        array[position++] = value;
        modCount++;
    }

    public E get(int index) {
        return (E) array[index];
    }

    public void checkTheSizeArray() {
        int minSize = defaultSize;
        if (position == minSize) {
            this.defaultSize = minSize * 3 / 2;
            this.array = Arrays.copyOf(array, defaultSize);
        }
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int position = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return array.length > position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) array[position++];
            }
        };
    }
}

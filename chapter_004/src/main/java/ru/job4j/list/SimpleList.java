package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 25.04.2018
 */
public class SimpleList<E> implements Iterable<E> {
    private Object[] container;
    private int position = 0;
    private int defaultSize = 10;
    private int modCount = 0;

    public SimpleList() {
        this.container = new Object[defaultSize];
    }

    public void add(E value) {
        checkTheSizeArray();
        container[position++] = value;
        modCount++;
    }

    public E get(int index) {
        return (E) container[index];
    }

    public void checkTheSizeArray() {
        int minSize = defaultSize;
        if (position == minSize) {
            this.defaultSize = minSize * 3 / 2;
            this.container = Arrays.copyOf(container, defaultSize);
        }
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
                return container.length > pos;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[pos++];
            }
        };
    }
}

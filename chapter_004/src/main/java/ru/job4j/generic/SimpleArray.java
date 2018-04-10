package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 10.04.2018
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int position = 0;

    public SimpleArray(Object[] objects) {
        this.objects = objects;
    }

    public void add(T model) {
        objects[position++] = model;
    }

    public void set(int index, T model) {
        objects[index] = model;
    }

    public void delete(int index) {
        Object[] copyObject = objects;
        int position = index + 1;
        System.arraycopy(copyObject, position, objects, index, objects.length - (index + 1));
    }

    public Object get(int index) {
        return objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pos = 0;

            @Override
            public boolean hasNext() {
                return objects.length > pos;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[pos++];
            }
        };
    }
}

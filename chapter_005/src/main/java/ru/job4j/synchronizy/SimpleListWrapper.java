package ru.job4j.synchronizy;

import java.util.Iterator;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 18.11.2018
 */
@ThreadSafe
public class SimpleListWrapper<E> implements SimpleArr<E> {
    @GuardedBy("this")
    private SimpleList<E> list;
    private int size = 0;

    public SimpleListWrapper() {
        this.list = new SimpleList<>();
    }

    @Override
    public synchronized void add(E value) {
        list.add(value);
        size++;
    }

    public synchronized int getSize() {
        return size;
    }

    @Override
    public synchronized E get(int index) {
        return list.get(index);
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return copy(this.list).iterator();
    }

    public synchronized SimpleList<E> copy(SimpleList<E> arr) {
        SimpleList<E> list = new SimpleList<>();
        Object[] list1 = arr.getArray();
        list.setArray(list1);
        return list;
    }
}

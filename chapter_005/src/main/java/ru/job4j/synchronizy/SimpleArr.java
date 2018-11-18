package ru.job4j.synchronizy;


/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 18.11.2018
 */
public interface SimpleArr<E> extends Iterable<E> {

    void add(E value);

    E get(int index);
}

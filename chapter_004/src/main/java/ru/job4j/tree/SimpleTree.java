package ru.job4j.tree;

import java.util.Optional;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 12.07.2018
 */
public interface SimpleTree<E> extends Iterable<E> {
    boolean add(E parent, E child);

    Optional<Node> findBy(E value);
}

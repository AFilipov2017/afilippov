package ru.job4j.chess;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 05.03.2018
 */
public abstract class Figure {
    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract Figure copy(Cell dest);
}

package ru.job4j.chess;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 05.03.2018
 */
public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * Метод определяет как должна ходить фигура Bishop.
     *
     * @param source, dest, rez итоговый массив возвращает путь фигуры.
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] result = new Cell[Math.abs((source.getX() - dest.getX())) + 1];
        int coordX = source.getX();
        int coordXd = dest.getX();
        int coordY = source.getY();
        int coordYd = dest.getY();
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            int i = 0;
            do {
                result[i] = new Cell(coordX, coordY);
                coordX = changeCoord(coordX, coordXd);
                coordY = changeCoord(coordY, coordYd);
                i++;
            } while (i < result.length);
        } else {
            throw new ImpossibleMoveException("Impossible move");
        }
        return result;
    }

    public int changeCoord(int a, int b) {
        BiFunction<Integer, Integer, Integer> func = (n, m) -> Integer.compare(n, m);
        Predicate<Integer> predicate = (n) -> n == 1;
        return predicate.test(func.apply(a, b)) ? a - 1 : a + 1;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
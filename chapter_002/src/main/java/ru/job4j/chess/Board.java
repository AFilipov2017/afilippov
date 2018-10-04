package ru.job4j.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 05.03.2018
 */
public class Board {
    private List<Figure> figures = new ArrayList<>();
    private int ind = 0;

    public Board(List<Figure> figures) {
        this.figures = figures;
    }

    public Figure add(Figure figure) {
        this.figures.add(figure);
        return figure;
    }

    /**
     * Метод имитирует ход фигуры на шахматной доске.
     *
     * @param source, dest начальная и конечная ячейки хода фигуры.
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        int index = indexOf(source);
        if (figures.get(index).position.getX() == source.getX() && figures.get(index).position.getY() == source.getY()) {
            result = true;
        }
        if (!result) {
            throw new FigureNotFoundException("Figure not found");
        }

        Predicate<Integer> p = n -> n > 8 || n <= 0;
        if (p.test(source.getX()) || p.test(source.getY()) || p.test(dest.getX()) || p.test(dest.getY())) {
            throw new ImpossibleMoveException("Impossible move exception.");
        }

        List<Cell> way = figures.get(index).way(source, dest);
        way.forEach(m -> figures.forEach(n -> {
            if (n.position.getX() == m.getX() && n.position.getY() == m.getY()) {
                throw new OccupiedWayException("Occupied way.");
            }
        }));
        figures.set(index, figures.get(index).copy(dest));
        return result;
    }

    int indexOf(Cell cell) {
        figures.forEach(n -> {
            if (cell.getX() == n.position.getX() && cell.getY() == n.position.getY()) {
                ind = figures.indexOf(n);
            }
        });
        return ind;
    }
}








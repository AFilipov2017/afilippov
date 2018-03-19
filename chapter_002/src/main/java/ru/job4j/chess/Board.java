package ru.job4j.chess;


/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 05.03.2018
 */

public class Board {
    private Figure[] figures = new Figure[32];
    private int position = 0;

    public Board(Figure[] figures) {
        this.figures = figures;
    }

    public Figure add(Figure figure) {
        this.figures[this.position++] = figure;
        return figure;
    }

    /**
     * Метод имитирует ход фигуры на шахматной доске.
     *
     * @param source, dest начальная и конечная ячейки хода фигуры.
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;

        for (int i = 0; i < this.position; i++) {
            if (figures[i].position.getX() == source.getX() && figures[i].position.getY() == source.getY()) {
                result = true;
            }
        }
        if (!result) {
            throw new FigureNotFoundException("Figure not found");
        }
        if (source.getY() <= 0 || source.getY() > 8 || source.getX() <= 0 || source.getX() > 8
                || dest.getY() <= 0 || dest.getY() > 8 || dest.getX() <= 0 || dest.getX() > 8) {
            throw new ImpossibleMoveException("Impossible move exception.");
        }
        int index = indexOf(source);
        Cell[] way = figures[index].way(source, dest);
        for (int j = 1; j < way.length; j++) {
            for (int k = 0; k < this.position; k++) {
                if (figures[k].position.getX() == way[j].getX() && figures[k].position.getY() == way[j].getY()) {
                    throw new OccupiedWayException("Occupied way.");
                }
            }
        }
        figures[index] = figures[index].copy(dest);
        return result;
    }

    int indexOf(Cell cell) {
        int index = 0;
        for (int i = 0; i < this.position; i++) {
            if (cell.getX() == figures[i].position.getX() && cell.getY() == figures[i].position.getY()) {
                index = i;
            }
        }
        return index;
    }
}








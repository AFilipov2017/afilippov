package ru.job4j.chess;

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
        Cell[] rez = new Cell[Math.abs((source.getX() - dest.getX())) + 1];
        int a = 0;
        int c = source.getY();
        int b = dest.getY();
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            if (source.getX() > dest.getX()) {
                for (int i = source.getX(); i >= dest.getX(); i--) {
                    rez[a] = new Cell(i, c);
                    if (c < b) {
                        c++;
                    }
                    if (c > b) {
                        c--;
                    }
                    a++;
                }
            } else {
                for (int i = source.getX(); i <= dest.getX(); i++) {
                    rez[a] = new Cell(i, c);
                    if (c < b) {
                        c++;
                    }
                    if (c > b) {
                        c--;
                    }
                    a++;
                }
            }
            return rez;
        } else {
            throw new
                    ImpossibleMoveException("Impossible move exception");
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}

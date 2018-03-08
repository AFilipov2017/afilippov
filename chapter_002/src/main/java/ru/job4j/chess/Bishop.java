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
        int x = source.getX();
        int y = source.getY();
        int d = Integer.compare(source.getX(), dest.getX());
        int f = Integer.compare(source.getY(), dest.getY());
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            for (int j = 0; j < rez.length; j++) {
                rez[j] = new Cell(x, y);
                if (d == 1) {
                    x--;
                } else {
                    x++;
                }
                if (f == 1) {
                    y--;
                } else {
                    y++;
                }
            }
        } else {
            throw new ImpossibleMoveException("Impossible move");
        }
        return rez;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
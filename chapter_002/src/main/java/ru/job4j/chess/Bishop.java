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
        Cell[] result = new Cell[Math.abs((source.getX() - dest.getX())) + 1];
        int coordX = source.getX();
        int coordY = source.getY();
        int deltaX = Integer.compare(source.getX(), dest.getX());
        int deltaY = Integer.compare(source.getY(), dest.getY());
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            int i = 0;
            do {
                result[i] = new Cell(coordX, coordY);
                coordX = deltaX == 1 ? coordX - 1 : coordX + 1;
                coordY = deltaY == 1 ? coordY - 1 : coordY + 1;
                i++;
            } while (i < result.length);
        } else {
            throw new ImpossibleMoveException("Impossible move");
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
package ru.job4j.chess;

public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

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
     public  Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}

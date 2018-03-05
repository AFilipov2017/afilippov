package ru.job4j.chess;


public class Board {
    private Figure[] figures = new Figure[32];
    private int position = 0;

    public Figure add(Figure figure) {
        this.figures[this.position++] = figure;
        return figure;
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Cell[] path;
        for (int i = 0; i < this.position; i++) {
            if (figures[i].position.getY() == source.getY() && figures[i].position.getX() == source.getX()) {
                path = figures[i].way(source, dest);

                for (int j = 1; j < path.length; j++) {
                    for (int k = 0; k < this.position; k++) {
                        if (figures[k].position.getX() == path[j].getX() && figures[k].position.getY() == path[j].getY()) {
                            throw new OccupiedWayException("Occupied way");
                        } else {
                            figures[i].copy(dest);

                        }
                    }
                }

            } else throw new FigureNotFoundException("Figure not found");
        }
        return true;
    }
}


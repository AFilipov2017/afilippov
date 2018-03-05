package ru.job4j.chess;


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

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Cell[] path;
        int b = 0;
        Figure figure = null;
        boolean rez = false;
        for (int i = 0; i < this.position; i++) {
            if (figures[i].position.getX() == source.getX() && figures[i].position.getY() == source.getY()) {
                figure = figures[i];
                path = figures[i].way(source, dest);
                b = i;
                rez = true;
                for (int j = 1; j < path.length; j++) {
                    for (int k = 0; k < this.position; k++) {
                        if (figures[k].position.getX() == path[j].getX() && figures[k].position.getY() == path[j].getY()) {
                            throw new OccupiedWayException("Occupied way");
                        }
                    }
                }

            }


        }
        figures[b] = figure.copy(dest);

        if (!rez) {
            throw new FigureNotFoundException("Figure not found");
        }

        return rez;
    }
}








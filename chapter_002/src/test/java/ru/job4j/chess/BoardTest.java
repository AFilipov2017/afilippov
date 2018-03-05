package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenFigureMove(){
        Cell source = new Cell(6, 1);
        Figure bishop = new Bishop(source);
        Figure[] f = new Figure[] {bishop};
        Board board = new Board(f);

        Cell dest = new Cell(3, 4);


        board.add(bishop);
        board.move(source,dest);
        Cell result = new Cell(3, 4);
        assertThat(f[0].position, is(dest));

    }
}

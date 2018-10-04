package ru.job4j.chess;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version $Id$
 * @since 05.03.2018
 */

public class BoardTest {
    /**
     * Test Figure can go.
     */
    @Test
    public void whenFigureCanGoThenOk() {
        Cell source = new Cell(6, 1);
        Figure bishop = new Bishop(source);
        List<Figure> f = new ArrayList<>();
        Board board = new Board(f);
        Cell dest = new Cell(3, 4);
        board.add(bishop);
        board.move(source, dest);
        assertThat(f.get(0).position, is(dest));
    }

    /**
     * Test Figure way is occupied.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenWayOfFigureIsOccupied() {
        Figure bishop = new Bishop(new Cell(6, 1));
        Figure bishop1 = new Bishop(new Cell(4, 3));
        List<Figure> f = new ArrayList<>();
        Board board = new Board(f);
        board.add(bishop);
        board.add(bishop1);
        Cell source = new Cell(6, 1);
        Cell dest = new Cell(3, 4);
        board.move(source, dest);
    }

    /**
     * Test Figure not found.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() {
        Figure bishop = new Bishop(new Cell(6, 1));
        Figure bishop1 = new Bishop(new Cell(4, 3));
        List<Figure> f = new ArrayList<>();
        Board board = new Board(f);
        board.add(bishop);
        board.add(bishop1);
        Cell source = new Cell(5, 1);
        Cell dest = new Cell(3, 4);
        board.move(source, dest);
    }

    /**
     * Test Figure impossible to move.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenFigureImpossibleToMove() {
        Figure bishop = new Bishop(new Cell(6, 1));
        List<Figure> f = new ArrayList<>();
        Board board = new Board(f);
        board.add(bishop);
        Cell dest = new Cell(0, 8);
        board.move(bishop.position, dest);
    }

    /**
     * Test Bishop can't go.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBishopImpossibleToMove() {
        Figure bishop = new Bishop(new Cell(6, 1));
        List<Figure> f = new ArrayList<>();
        Board board = new Board(f);
        board.add(bishop);
        Cell dest = new Cell(6, 4);
        board.move(bishop.position, dest);
    }
}

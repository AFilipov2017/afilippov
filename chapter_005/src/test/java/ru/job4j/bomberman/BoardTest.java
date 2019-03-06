package ru.job4j.bomberman;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 06.12.2018
 */
public class BoardTest {
@Ignore
    @Test
    public void whenMoveInFreeSpace() throws InterruptedException {
        Board board = new Board(5);
        board.lock(new Cell(0, 0));
        assertTrue(board.move(new Cell(0, 0), new Cell(1, 0)));
        assertTrue(board.move(new Cell(1, 0), new Cell(1, 1)));
        assertTrue(board.move(new Cell(1, 1), new Cell(2, 1)));
        assertTrue(board.move(new Cell(2, 1), new Cell(1, 1)));
        assertTrue(board.move(new Cell(1, 1), new Cell(2, 1)));
    }
@Ignore
    @Test
    public void whenJustOneWay() throws InterruptedException {
        Board board = new Board(3);
        board.lock(new Cell(1, 1));
        Thread t = new Thread(() -> {
            board.lock(new Cell(0, 0));
            board.lock(new Cell(0, 1));
            board.lock(new Cell(0, 2));
            board.lock(new Cell(1, 0));

            board.lock(new Cell(2, 0));
            board.lock(new Cell(2, 1));
            board.lock(new Cell(2, 2));
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(board.move(new Cell(1, 1), new Cell(1, 0)));
    }
}

package ru.job4j.bomberman;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 06.12.2018
 */
public class Board {

    private final ReentrantLock[][] board;

    public Board(int length) {
        this.board = new ReentrantLock[length][length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    public int getLength() {
        return board.length;
    }

    public boolean move(Cell source, Cell dest) {
        boolean result = false;
        System.out.println(source.getY() + " " + source.getX() + "   " + dest.getY() + " " + dest.getX());
        Predicate<Integer> pr = (a) -> a >= 0 && a < board.length;
        do {
            if (pr.test(dest.getY()) && pr.test(dest.getX()) && board[dest.getY()][dest.getX()].tryLock()) {
                board[source.getY()][source.getX()].unlock();
                source.setY(dest.getY());
                source.setX(dest.getX());
                Cell a = randomMove(source);
                dest.setY(a.getY());
                dest.setX(a.getX());
                result = true;
            } else {
                Cell c = randomMove(source);
                dest.setY(c.getY());
                dest.setX(c.getX());
            }
        } while (!result);

        return result;
    }

    public Cell randomMove(Cell cell) {
        int[] ar = new int[]{-1, 1};
        Random random = new Random();
        Cell newCell = new Cell(cell.getY(), cell.getX());
        int randVar = random.nextInt(2);
        int changeVar = ar[random.nextInt(2)];
        if (randVar == 0) {
            newCell.setY(cell.getY() + changeVar);
        } else {
            newCell.setX(cell.getX() + changeVar);
        }
        return newCell;
    }

    public boolean lock(Cell cell) {
        return board[cell.getY()][cell.getX()].tryLock();
    }

    public Cell randomPosition() {
        Random rnd = new Random();
        int[] arr = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            arr[i] = i;
        }
        Cell cell = new Cell(arr[rnd.nextInt(board.length)], arr[rnd.nextInt(board.length)]);
        System.out.println("blocks of labyrinth " + cell.getY() + " " + cell.getX());
        return cell;
    }
}

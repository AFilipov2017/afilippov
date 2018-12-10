package ru.job4j.bomberman;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 09.12.2018
 */
public class Game {

    private Board board = new Board(5);

    public void putMonsters(int number, int speed) {
        for (int i = 0; i < number; i++) {
            putBombMan(speed);
        }
    }

    public void moduleOfLabyrinth(int number) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < number; i++) {
                board.lock(board.randomPosition());
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void putBombMan(int speed) {
        Thread t = new Thread(() -> {
            Cell creature = board.randomPosition();
            Cell creatureDest = board.randomMove(creature);
            board.lock(creature);
            while (true) {
                boolean a = false;
                while (!a) {
                    a = board.lock(creature);
                }
                try {
                    board.move(creature, creatureDest);
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        System.out.println(t.getName());
    }
}

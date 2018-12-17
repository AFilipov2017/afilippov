package ru.job4j.bomberman;


/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 09.12.2018
 */
public class Game {

    private Board board = new Board(2);

    public void putMonsters(int number, int speed) {
        for (int i = 0; i < number; i++) {
           Thread t = new Thread(() -> {
                Cell creature = board.randomPosition();
                Cell creatureDest = board.randomMove(creature);
                while (true) {
                    boolean a = false;
                    while (!a) {
                        a = board.lock(creature);
                    }
                    try {
                        System.out.println("monster");
                        board.move(creature, creatureDest);
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
           t.setDaemon(true);
           t.start();
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
            boolean b = false;
            while (!b){
                boolean a = false;
                while (!a) {
                    a = board.lock(creature);
                }
                try {
                    System.out.println("bombman");
                    board.move(creature, creatureDest);
                    Thread.sleep(speed);
                    b = board.gameOver(creature);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getName());
    }



}

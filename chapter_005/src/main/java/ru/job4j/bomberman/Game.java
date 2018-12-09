package ru.job4j.bomberman;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 09.12.2018
 */
public class Game {

    private Board board = new Board(3);
    private Bman bman = new Bman(1, 1);

    public void start() {
        Thread t = new Thread(() -> {
            board.lock(bman);
            while (true){
                try {
                    board.move(bman, new Cell(1, 0));
                    Thread.sleep(1000);
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
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

package ru.job4j.bomberman;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 10.12.2018
 */
public class Start {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
        Game game = new Game();
        pool.execute(() -> game.moduleOfLabyrinth(5));
        pool.execute(() -> game.putMonsters(5, 5000));
        pool.execute(() -> game.putBombMan(1000));
    }
}

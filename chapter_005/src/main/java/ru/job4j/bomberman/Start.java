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
        Game game = new Game();

        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        ex.submit(()-> {game.moduleOfLabyrinth(1);
            game.putMonsters(1, 2000);
            game.putBombMan(1000);
        });
    }
}

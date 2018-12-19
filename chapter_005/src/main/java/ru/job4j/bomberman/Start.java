package ru.job4j.bomberman;



/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 10.12.2018
 */
public class Start {
    public static void main(String[] args) {
            Game game = new Game();
            game.putMonsters(2, 1600);
            game.putBombMan(1000);
    }
}

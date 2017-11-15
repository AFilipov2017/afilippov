package ru.job4j.condition;
/**
 * @author afilippov
 * @version 1
 * @since 14.11.2017
 */
 
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean is(int a, int b) {


        if (y == a * x + b) {

          return this.y == this.x * a + b;
        }
        return false;
    }
}


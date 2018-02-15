package ru.job4j.pseudo;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 15.02.2018
 */
public class Start {
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        System.out.println("");
        paint.draw(new Square());
    }
}

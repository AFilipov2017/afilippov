package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 16.10.2018
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int stepX = 1;
        int stepY = 1;
        while (true) {
            if (rect.getX() >= 300) {
                stepX = -1;
            }
            if (rect.getX() <= 0) {
                stepX = 1;
            }
            if (rect.getY() >= 300) {
                stepY = -1;
            }
            if (rect.getY() <= 0) {
                stepY = 1;
            }
            this.rect.setX(this.rect.getX() + stepX);
            this.rect.setY(this.rect.getY() + stepY);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

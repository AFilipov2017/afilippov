package ru.job4j.loop;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 20.11.2017
 */

public class Board {
    public String paint(int width, int height) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    sb.append("x");
                } else {
                    sb.append(" ");
                }
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();

    }
}


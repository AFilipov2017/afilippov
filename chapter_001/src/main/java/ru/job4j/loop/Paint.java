package ru.job4j.loop;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 20.11.2017
 */

public class Paint {
    /**
     * метод строит пирамиду в псевдографике с заданной высотой.
     * @param  h
     * @return пирамида в консоли
     */
    public  static String piramid(int h) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = -h + 1; j < h; j++) {
                if (i >= Math.abs(j)) {
                    sb.append("^");
                } else {
                    sb.append(" ");
                }
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
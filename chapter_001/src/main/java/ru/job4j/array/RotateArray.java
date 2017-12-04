package ru.job4j.array;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 01.12.2017
 */

public class RotateArray {
    /**
     * Метод поворачивает массив на 90 градусов по часовой стрелке
     * @param array массив для поворота
     */

    public static int[][] rotate(int[][] array) {
        int[][] arr = new int[array.length][array[0].length];
                for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                arr[i][j] = array[array[j].length - 1 - j][i];
            }
        }
        return arr;
    }
}

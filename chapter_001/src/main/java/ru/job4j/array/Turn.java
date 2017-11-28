package ru.job4j.array;

import java.lang.reflect.Array;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 20.11.2017
 */

public class Turn {
    /**
     * метод переворачивает значения массива в обратном порядке.
     * @param  array
     * @return возвращает измененный массив
     */
    public static int[] back(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
            }
        }
        return array;
    }
}
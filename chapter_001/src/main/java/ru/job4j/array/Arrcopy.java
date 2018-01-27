package ru.job4j.array;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 25.01.2018
 */

import java.util.Arrays;

public class Arrcopy {
    /**
     * Метод склеивает два массива в третий, затем сортирует
     * @param arr1, arr2, исходные массивы, arr3 конечный массив
     */

    public int[] twoarraysort(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        Arrays.sort(arr3);
        return arr3;
    }
}


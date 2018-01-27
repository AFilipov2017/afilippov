package ru.job4j.array;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 25.01.2018
 */
public class Arrcopyvol2 {
    /**
     * Метод сортирует два массива в третий, методом сливания, взятым из книги Седжвика и Уэйна «Алгоритмы на Java»
     *
     * @param arr1, arr2, исходные массивы, arr3 конечный массив
     */
    public int[] twoArraySortMerge(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        for (int k = 0; k < arr3.length; k++) {
            if (i > arr1.length - 1) {
                int a = arr2[j];
                arr3[k] = a;
                j++;
            } else if (j > arr2.length - 1) {
                int a = arr1[i];
                arr3[k] = a;
                i++;
            } else if (arr1[i] < arr2[j]) {
                int a = arr1[i];
                arr3[k] = a;
                i++;
            } else {
                int b = arr2[j];
                arr3[k] = b;
                j++;
            }
        }
        return arr3;
    }
}



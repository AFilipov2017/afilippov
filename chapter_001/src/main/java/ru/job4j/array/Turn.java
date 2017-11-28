package ru.job4j.array;

import java.lang.reflect.Array;

public class Turn {

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 12, 15, 18};
        back(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

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
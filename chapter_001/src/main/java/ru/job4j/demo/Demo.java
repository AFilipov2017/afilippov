package ru.job4j.demo;

import java.util.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 13.08.2018
 */
public class Demo {
    private int[] array;

    public Demo(int[] array) {
        this.array = array;
    }

    public int binarySearch(int a) {
        int zro = array[0];
        int end = array[array.length - 1];

        while (zro <= end) {
            int abs = (end + zro) / 2;
            int guess = array[abs];
            if (guess == a) {
                return abs;
            }
            if (guess > a) {
                end = abs - 1;
            } else {
                zro = abs + 1;
            }
        }
        return 0;
    }

    public int smallest(int[] array) {
        int small = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < small) {
                small = array[i];
                index = i;
            }
        }
        return index;
    }

    public int[] sortedArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int imin = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    imin = j;
                }
            }
            if (i != imin) {
                int temp = a[i];
                a[i] = a[imin];
                a[imin] = temp;
            }
        }
        return a;
    }

    public int[] sortedMass(int[] mass, int start, int end ) {
        if (start >= end) {return mass;}
        int i = start;
       int j = end;
       int op =  i -(i - j)/2;

       while(i < j) {
            while(i < op && mass[i] <= mass[op]) {
                i++;}

            while (j > op && mass[j] >= mass [op]){
                j--;}

            if (i < j) {
                int temp = mass[i];
                mass[i] = mass[j];
                mass[j] = temp;
                if(i == op){op = j;} else {if(j == op) {op = i;}}
            }
       }
       sortedMass(mass, start, op);
       sortedMass(mass, op + 1 , end);
       return mass;
           }

    public int sum(final int[] array) {
        if (array.length==0)
            return 0;
        else return array[0]+sum(Arrays.copyOfRange(array, 1, array.length));

    }


    public static void main(String[] args) {

    }
}


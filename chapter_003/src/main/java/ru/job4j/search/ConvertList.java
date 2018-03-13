package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 12.02.2018
 */
public class ConvertList {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        int cell;
        int a = list.size() / rows;
        if (list.size() % rows == 0) {
            cell = a;
        } else {
            cell = ++a;
        }

        int[][] arr = new int[rows][cell];
        Iterator<Integer> iterator = list.listIterator();
        for (int[] i : arr) {
            for (int j = 0; j < i.length; j++) {
                i[j] = iterator.hasNext() ? iterator.next() : 0;
            }
        }
        return arr;
    }


    public List<Integer> convert (List<int[]> list) {
        List<Integer> rez = new ArrayList<>();
        for (int [] i: list             ) {
            for (int z : i) {
                rez.add(z);
            }
        }
        return rez;
    }
}
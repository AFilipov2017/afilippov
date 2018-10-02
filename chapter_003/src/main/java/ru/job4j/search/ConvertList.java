package ru.job4j.search;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 12.02.2018
 */
public class ConvertList {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        Stream<int[]> arr = Arrays.stream(array);
        Iterator<int[]> split = arr.iterator();
        split.forEachRemaining((n) -> {
            for (Integer c : n) {
                list.add(c);
            }
        });
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
        Stream<Integer> str = list.stream();
        Iterator<Integer> iterator = str.iterator();
        for (int[] i : arr) {
            for (int j = 0; j < i.length; j++) {
                i[j] = iterator.hasNext() ? iterator.next() : 0;
            }
        }
        return arr;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        Stream<int[]> str = list.stream();
        Iterator<int[]> split = str.iterator();
        split.forEachRemaining((n) -> {
            for (Integer c : n) {
                result.add(c);
            }
        });
        return result;
    }
}

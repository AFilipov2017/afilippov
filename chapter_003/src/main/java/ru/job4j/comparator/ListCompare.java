package ru.job4j.comparator;

import java.util.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 18.03.2018
 */
public class ListCompare implements Comparator<String> {
    /**
     * Метод сравнивает строки в лексикографическом порядке.
     *
     * @param left, right строки для сравнения.
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = Integer.min(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            result = Character.compare(
                    left.charAt(i),
                    right.charAt(i)
            );
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
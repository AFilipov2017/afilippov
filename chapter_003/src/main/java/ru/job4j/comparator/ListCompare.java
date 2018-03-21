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
        List<Character> one = new ArrayList<>();
        List<Character> two = new ArrayList<>();
        for (char symbol : left.toCharArray()) {
            one.add(symbol);
        }
        for (char symbol2 : right.toCharArray()) {
            two.add(symbol2);
        }

        int loopSize = one.size() == two.size() ? one.size() : one.size() < two.size() ? one.size() : two.size();
        int index = 0;
        for (int i = 0; i < loopSize; i++) {
            int res = one.get(i) == two.get(i) ? 0 : one.get(i) < two.get(i) ? -1 : 1;
            index += res;
        }

        if (index == 0) {
            result = one.size() == two.size() ? result : one.size() < two.size() ? -1 : 1;
        } else {
            result = index < 0 ? -1 : 1;
        }
        return result;
    }
}
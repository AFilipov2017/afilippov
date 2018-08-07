package ru.job4j.additionaltask;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 07.08.2018
 */
public class CoffeeMachine {
    public Integer[] changes(int value, int price) {
        int[] coin = {10, 5, 2, 1};
        List<Integer> list = new ArrayList<>();
        Integer[] result;
        int a = value - price;
        int index = 0;

        while (a != 0) {
            if (a >= coin[index]) {
                list.add(coin[index]);
                a -= coin[index];
            } else {
                ++index;
            }
        }
        result = new Integer[list.size()];
        result = list.toArray(result);
        return result;
    }
}


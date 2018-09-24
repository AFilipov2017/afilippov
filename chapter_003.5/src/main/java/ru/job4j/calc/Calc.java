package ru.job4j.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 24.09.2018
 */
public class Calc {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (double i = start; i <= end; i++) {
            list.add(func.apply(i));
        }
        return list;
    }
}

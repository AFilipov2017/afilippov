package ru.job4j.loop;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 20.11.2017
 */

public class Counter {

    public static int add(int start, int finish) {
/**
 *  Метод должен вычислять сумму четных чисел в диапазоне от start до finish.
 *
 *  @param start, finish.
 *
 *  @return сумма четных чисел.
 */

        int rez = 0;
        for (int i = start; i <= finish; i++) {

            if (i % 2 == 0) {
                int a = i;
                rez += a;
            }
        }
        return rez;
    }
}
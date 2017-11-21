package ru.job4j.loop;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 20.11.2017
 */

public class Factorial {
    /**
     *  Метод должен возвращать рассчитанный факториал.
     * @param n, n.
     * @return  рассчитанный факториал для этого числа n.
     */

    public int calc(int n) {
        int rez = 1;
        if (n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            int a = i;
            rez = rez * a;
        }
        return rez;
    }
}
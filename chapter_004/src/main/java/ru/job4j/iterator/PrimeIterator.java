package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 8.04.2018
 */
public class PrimeIterator implements Iterator<Integer> {
    private final int[] values;
    private int index = 0;

    public PrimeIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean res = false;
        for (int i = index; i < values.length; i++) {
            res = isPrime(values[i]);
        }
        return res;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (!isPrime(values[index])) {
            index++;
        }
        return values[index++];
    }

    public boolean isPrime(int num) {
        boolean result = true;
        if (num < 2) {
            result = false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                result = false;
            }
        }
        return result;
    }
}

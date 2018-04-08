package ru.job4j.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 7.04.2018
 */
public class EvenIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int index = 0;

    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean res = false;
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                res = true;
            }
        }
        return res;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (numbers[index] % 2 != 0) {
            index++;
        }
        return numbers[index++];
    }
}

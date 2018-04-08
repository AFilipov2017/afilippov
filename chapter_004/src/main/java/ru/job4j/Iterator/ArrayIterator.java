package ru.job4j.Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 7.04.2018
 */
public class ArrayIterator implements Iterator<Integer> {
    private final int[][] values;
    private int indexRow = 0;
    private int indexColumn = 0;

    public ArrayIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return this.values.length > indexRow && this.values[indexRow].length > indexColumn;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = values[indexRow][indexColumn++];
        if (this.values[indexRow].length < indexColumn + 1) {
            indexRow++;
            indexColumn = 0;
        }
        return result;
    }
}

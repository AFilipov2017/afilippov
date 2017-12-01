package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray array = new RotateArray();
        int[][] resultArray = array.rotate(new int[][]{{1, 2}, {3, 4}});
        int[][] expectArray = new int[][] {{3, 1}, {4, 2}};
        assertThat(resultArray, is(expectArray));
    }

    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray array = new RotateArray();
        int[][] resultArray = array.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[][] expectArray = new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(resultArray, is(expectArray));
    }
}
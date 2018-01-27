package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrcopyTest {
    @Test
    public void ifSortTwoArraysByTheMerger() {
        Arrcopy arrcopy = new Arrcopy();
        int[] arrOne = {1, 8, 9};
        int[] arrTwo = {3, 6, 7};
        int[] resultArray = arrcopy.twoarraysort(arrOne, arrTwo);
        int[] expectArray = new int[] {1, 3, 6, 7, 8, 9};
        assertThat(resultArray, is(expectArray));

    }

    @Test
    public void ifSortTwoArrays() {
        Arrcopy arrcopy = new Arrcopy();
        int[] arr1 = {1, 9, 9};
        int[] arr2 = {3, 5, 8};
        int[] resultArray = arrcopy.twoarraysort(arr1, arr2);
        int[] expectArray = new int[] {1, 3, 5, 8, 9, 9};
        assertThat(resultArray, is(expectArray));

    }
}

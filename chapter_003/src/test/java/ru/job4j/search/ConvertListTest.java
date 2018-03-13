package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since
 */
public class ConvertListTest {
    @Test
    public void whenArrayConvertToList() {
        ConvertList convertList = new ConvertList();
        int[][] a = new int[][]{{1, 2}, {3, 4}};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> result = convertList.toList(a);
        assertThat(result, is(list));
    }

    @Test
    public void whenArrayConvertToListTwo() {
        ConvertList convertList = new ConvertList();
        int[][] a = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        List<Integer> result = convertList.toList(a);
        assertThat(result, is(list));
    }

    @Test
    public void whenListConvertToArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        int[][] result = convertList.toArray(list, 3);
        assertThat(result, is(expect));
    }

    @Test
    public void whenListConvertToArrayTwo() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        int[][] expect = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        int[][] result = convertList.toArray(list, 2);
        assertThat(result, is(expect));
    }

    @Test
    public void whenListArraysConvertList() {
        ConvertList convertList = new ConvertList();
        List<int []> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(list);
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        expect.add(5);
        expect.add(6);
        assertThat(result, is(expect));
    }
}

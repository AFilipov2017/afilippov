package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 10.04.2018
 */
public class SimpleArrayTest {

    @Test
    public void whenAddObject() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Object[1]);
        simpleArray.add(5);
        Object result = simpleArray.get(0);
        assertThat(result, is(5));
    }

    @Test
    public void whenEditValue() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Object[1]);
        simpleArray.add(2);
        simpleArray.set(0, 1);
        Object result = simpleArray.get(0);
        assertThat(result, is(1));
    }

    @Test
    public void whenDeleteByIndex() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Object[5]);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.delete(0);
        Object result = simpleArray.get(0);
        assertThat(result, is(2));
    }

    @Test
    public void whenGetByIndex() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Object[5]);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        Object result = simpleArray.get(0);
        assertThat(result, is(1));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(new Object[6]);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.add(6);
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }
}

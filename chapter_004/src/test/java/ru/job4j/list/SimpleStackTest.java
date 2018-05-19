package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 19.05.2018
 */
public class SimpleStackTest {

    @Test
    public void whenPushObject() {
        SimpleStack<Integer> list = new SimpleStack<>();
        list.push(5);
        list.push(2);
        int result = list.get(0);
        assertThat(result, is(5));
    }

    @Test
    public void whenDeleteObject() {
        SimpleStack<String> list = new SimpleStack<>();
        list.push("One");
        list.push("Two");
        list.poll();
        int result = list.getSize();
        assertThat(result, is(1));
    }

    @Test
    public void whenDeleteObjectTwo() {
        SimpleStack<String> list = new SimpleStack<>();
        list.push("One");
        list.push("Two");
        String result = list.poll();
        assertThat(result, is("Two"));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        SimpleStack<Integer> list = new SimpleStack<>();
        for (int i = 1; i <= 10; i++) {
            list.push(i);
        }
        Iterator<Integer> it = list.iterator();
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
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testConcurrentModificationExceptionWhenNextInvoked() {
        SimpleStack<Integer> list = new SimpleStack<>();
        for (int i = 0; i < 6; i++) {
            list.push(i);
        }
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        list.poll();
        it.next();
    }

}

package ru.job4j.set;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 23.05.2018
 */
public class LinkedSimpleSetTest {

    @Test
    public void whenAddObject() {
        LinkedSimpleSet<Integer> list = new LinkedSimpleSet<>();
        list.add(5);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        int result = it.next();
        assertThat(result, is(5));
    }

    @Test
    public void whenAddDuplicate() {
        LinkedSimpleSet<Integer> list = new LinkedSimpleSet<>();
        list.add(5);
        list.add(5);
        list.add(2);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        it.next();
        int result = it.next();
        assertThat(result, is(2));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        LinkedSimpleSet<Integer> list = new LinkedSimpleSet<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
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
        LinkedSimpleSet<Integer> list = new LinkedSimpleSet<>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        list.add(8);
        it.next();
    }
}

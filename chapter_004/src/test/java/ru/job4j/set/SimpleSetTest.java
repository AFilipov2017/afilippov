package ru.job4j.set;

import org.junit.Test;
import ru.job4j.list.SimpleList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 23.05.2018
 */
public class SimpleSetTest {

    @Test
    public void whenAddObject() {
        SimpleSet<Integer> list = new SimpleSet<>();
        list.add(5);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        int result = it.next();
        assertThat(result, is(5));
    }

    @Test
    public void whenAddDuplicate() {
        SimpleSet<Integer> list = new SimpleSet<>();
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
        SimpleSet<Integer> list = new SimpleSet<>();
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
        SimpleSet<Integer> list = new SimpleSet<>();
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

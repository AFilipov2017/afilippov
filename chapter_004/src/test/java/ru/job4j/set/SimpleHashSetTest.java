package ru.job4j.set;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 08.06.2018
 */
public class SimpleHashSetTest {

    @Test
    public void whenAddObject() {
        SimpleHashSet<Integer> list = new SimpleHashSet<>();
        boolean result = list.add(5);
        assertThat(result, is(true));
    }

    @Test
    public void whenContainsObject() {
        SimpleHashSet<String> list = new SimpleHashSet<>();
        list.add("One");
        list.add("Two");
        boolean result = list.contains("Two");
        assertThat(result, is(true));
    }

    @Test
    public void whenRemoveObject() {
        SimpleHashSet<String> list = new SimpleHashSet<>();
        list.add("One");
        list.add("Two");
        boolean result = list.remove("Three");
        assertThat(result, is(false));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        SimpleHashSet<Integer> list = new SimpleHashSet<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testConcurrentModificationExceptionWhenNextInvoked() {
        SimpleHashSet<Integer> list = new SimpleHashSet<>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        list.add(8);
        it.next();
    }
}

package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 25.04.2018
 */
public class SimpleListTest {

    @Test
    public void whenAddObject() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(5);
        list.add(2);
        int result = list.get(1);
        assertThat(result, is(2));
    }

    @Test
    public void whenGetObject() {
        SimpleList<String> list = new SimpleList<>();
        list.add("One");
        list.add("Two");
        String result = list.get(1);
        assertThat(result, is("Two"));
    }

    @Test
    public void whenAddWithAutogrowth() {
        SimpleList<Integer> list = new SimpleList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        int result = list.get(49);
        assertThat(result, is(49));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        SimpleList<Integer> list = new SimpleList<>();
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
        SimpleList<Integer> list = new SimpleList<>();
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

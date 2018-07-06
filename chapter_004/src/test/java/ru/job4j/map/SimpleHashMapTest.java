package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 05.07.2018
 */

public class SimpleHashMapTest {
    @Test
    public void whenAddObject() {
        SimpleHashMap<String, Integer> list = new SimpleHashMap<>();
        boolean result = list.insert("Alex", 20);
        assertThat(result, is(true));
    }

    @Test
    public void whenRemoveObject() {
        SimpleHashMap<String, Integer> list = new SimpleHashMap<>();
        list.insert("One", 1);
        list.insert("Two", 2);
        int result = list.getSize();
        boolean result1 = list.delete("Two");
        int result2 = list.getSize();
        assertThat(result, is(2));
        assertThat(result1, is(true));
        assertThat(result2, is(1));
    }

    @Test
    public void whenGetObject() {
        SimpleHashMap<String, Integer> list = new SimpleHashMap<>();
        list.insert("Alex", 25);
        Integer result = list.get("Alex");
        assertThat(result, is(25));
    }

    @Test
    public void whenKeysAreEqual() {
        SimpleHashMap<String, Integer> list = new SimpleHashMap<>();
        list.insert("Alex", 25);
        boolean result = list.insert("Alex", 12);
        assertThat(result, is(false));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        SimpleHashMap<Integer, Integer> list = new SimpleHashMap<>();
        list.insert(1, 5);
        list.insert(2, 4);
        list.insert(3, 3);
        list.insert(4, 2);
        list.insert(5, 1);
        Iterator<SimpleHashMap.Node> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(list.get(2)));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(list.get(3)));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(list.get(4)));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(list.get(5)));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testConcurrentModificationExceptionWhenNextInvoked() {
        SimpleHashMap<Integer, Integer> list = new SimpleHashMap<>();
        list.insert(1, 5);
        list.insert(2, 4);
        list.insert(3, 3);
        list.insert(4, 2);
        list.insert(5, 1);
        Iterator<SimpleHashMap.Node> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(list.get(2)));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(list.get(3)));
        list.insert(6, 3);
        it.next();
    }
}


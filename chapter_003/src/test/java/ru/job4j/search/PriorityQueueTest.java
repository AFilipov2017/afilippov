package ru.job4j.search;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 11.02.2018
 */

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("middle", 2));
        queue.put(new Task("middle1", 3));
        queue.put(new Task("urgent", 1));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriorityTwo() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 2));
        queue.put(new Task("middle", 3));
        queue.put(new Task("middleTwo", 1));
        queue.put(new Task("urgent", 5));
        Task result = queue.take();
        assertThat(result.getDesc(), is("middleTwo"));
    }
}

package ru.job4j.search;

import java.util.ListIterator;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since
 */
public class Demo {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.put(new Task("low", 5));
        q.put(new Task("urgent", 2));
        q.put(new Task("middle", 1));
        q.put(new Task("middle2", 2));
        System.out.println(q.take().getPriority());

    }
}

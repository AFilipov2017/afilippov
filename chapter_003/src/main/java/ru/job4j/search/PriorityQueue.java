package ru.job4j.search;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        tasks.add(task);
        List<Task> list = tasks.stream().sorted((o1, o2) -> Integer.compare(o1.getPriority(), o2.getPriority())).collect(Collectors.toList());
        tasks.clear();
        tasks.addAll(list);
    }

    public Task take() {
        return this.tasks.poll();
    }
}



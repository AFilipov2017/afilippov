package ru.job4j.search;

import java.util.*;

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
        if (tasks.size() == 0) {
            tasks.add(0, task);
        } else {
            if (task.getPriority() >= tasks.getLast().getPriority()) {
                tasks.add(task);
            } else {
                for (int i = tasks.size() - 1; i >= 0; i--) {
                    if (task.getPriority() <= tasks.get(i).getPriority()) {
                        tasks.add(i, task);
                    }
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}

package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 20.02.2019
 */
public interface ITracker {

    Item add(Item item);
    void replace(String id, Item item);
    void delete(String id);
    List<Item> findAll();
    List<Item> findByName(String key);
    Item findById(String id);
}

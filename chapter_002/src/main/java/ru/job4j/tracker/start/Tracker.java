package ru.job4j.tracker.start;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 06.02.2018
 */

import ru.job4j.tracker.models.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Tracker implements ITracker {
    private List<Item> items;
    private int position = 0;
    private static final Random RAND = new Random();

    public Tracker() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    /**
     * Метод добавляет заявку, переданную в аргументах в массив заявок this.items.
     *
     * @param
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод предоставляет уникальный ключ в объект Item item.
     *
     * @param
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RAND.nextInt());
    }

    /**
     * Метод должен заменить ячейку в массиве this.items.
     *
     * @param
     */
    public void replace(String id, Item item) {
        for (int i = 0; i != items.size(); i++) {
            if (id.equals(this.items.get(i).getId())) {
                this.items.set(i, item);
            }
        }
    }

    /**
     * Метод должен удалить ячейку в массиве this.items.
     *
     * @param
     */
    public void delete(String id) {
        for (int i = 0; i != this.items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                items.remove(i);
                break;
            }
        }
    }

    /**
     * Метод возвращает копию массива this.items без null элементов.
     *
     * @param
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        result.addAll(this.items);
        return result;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     *
     * @param
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        Predicate<String> predicate = (x) -> x.equals(key);
        items.forEach((n) -> {
            if (n != null && predicate.test(n.getName()) || n != null && predicate.test(n.getId())) {
                result.add(n);
            }
        });
        return result;
    }


    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     *
     * @param
     */
    public Item findById(String id) {
        return findByName(id).get(0);
    }
}
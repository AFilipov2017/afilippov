package ru.job4j.tracker.start;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 06.02.2018
 */

import ru.job4j.tracker.models.*;

import java.util.*;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RAND = new Random();

    /**
     * Метод добавляет заявку, переданную в аргументах в массив заявок this.items.
     *
     * @param
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int i = 0; i != this.position; i++) {
            if (id.equals(this.items[i].getId())) {
                this.items[i] = item;
            }
        }
    }

    /**
     * Метод должен удалить ячейку в массиве this.items.
     *
     * @param
     */
    public void delete(String id) {
        Item[] arr = new Item[this.items.length];
        System.arraycopy(this.items, 0, arr, 0, this.items.length);
        int b = 0;
        for (int i = 0; i != this.position; i++) {
            if (id.equals(arr[i].getId())) {
                arr[i] = null;
                b = i;
                break;
            }
        }

        System.arraycopy(arr, b + 1, this.items, b, this.position - b);
        this.position--;
    }

    /**
     * Метод возвращает копию массива this.items без null элементов.
     *
     * @param
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     *
     * @param
     */
    public Item[] findByName(String key) {
        Item[] first = new Item[this.position];
        int index = 0;
        int count = 0;
        for (int i = 0; i != this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                first[index] = this.items[i];
                index++;
                count++;
            }
        }
        Item[] res = new Item[count];
        System.arraycopy(first, 0, res, 0, count);
        return res;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     *
     * @param
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
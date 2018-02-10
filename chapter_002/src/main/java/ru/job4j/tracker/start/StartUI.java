package ru.job4j.tracker.start;

import ru.job4j.tracker.models.*;


/**
 * @version 1
 * @since 10.02.2018
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if ("1".equals(answer)) {
                this.showAllItems();
            } else if ("2".equals(answer)) {
                this.editItem();
            } else if ("3".equals(answer)) {
                this.deleteItem();
            } else if ("4".equals(answer)) {
                this.findItemById();
            } else if ("5".equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        String[] comm = new String[10];
        Item item = new Item(name, desc, 123L, comm);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует вывод списка всех заявок.
     */
    private void showAllItems() {
        System.out.println("------------ Список всех заявок --------------");
        Item[] rez = this.tracker.findAll();
        for (Item item : rez) {
            System.out.println("id: " + item.getId() + " " + "name: " + item.getName() + " " + "description: " + item.getDescription());
        }
    }
    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("------------   Редактирование заявки  --------------");
        String id = this.input.ask("Введите id :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        String[] comm = new String[10];
        Item items = new Item(name, desc, 123L, comm);
        items.setId(id);
        this.tracker.replace(id, items);
    }
    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------   Удаление заявки  --------------");
        String id = this.input.ask("Введите id :");
        tracker.delete(id);
    }
    /**
     * Метод реализует поиск заявки по ID.
     */
    private void findItemById() {
        System.out.println("------------   Поиск заявки по ID  --------------");
        String id = this.input.ask("Введите id :");
        Item item = tracker.findById(id);
        System.out.println("id: " + item.getId() + " " + "name: " + item.getName() + " " + "description: " + item.getDescription());
    }
    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findItemByName() {
        System.out.println("------------   Поиск заявки по имени  --------------");
        String key = this.input.ask("Введите имя заявки :");
        Item[] item = tracker.findByName(key);
        for (Item index : item) {
            System.out.println("id: " + index.getId() + " " + "name: " + index.getName() + " " + "description: " + index.getDescription());
        }

    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

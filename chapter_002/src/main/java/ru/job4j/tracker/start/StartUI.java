package ru.job4j.tracker.start;

/**
 * @version 1
 * @since 10.02.2018
 */
public class StartUI {

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
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillAction();
        do {
            menu.show();
            //int key = Integer.valueOf(input.ask("Select:"));
            menu.select(input.ask("Select", menu.range()));
        } while (!"y".equals(this.input.ask("Exit? (y/n)")));
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}

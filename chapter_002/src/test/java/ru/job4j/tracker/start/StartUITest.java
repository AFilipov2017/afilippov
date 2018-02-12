package ru.job4j.tracker.start;

import org.junit.Test;
import ru.job4j.tracker.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUserAddItemThenTrackerShowAllItemWithSameDesc() {
        Tracker tracker = new Tracker();     // создаём Tracker
        String[] comm = new String[10];
        Item item = tracker.add(new Item("name", "desc", 1L, comm));
        Input input = new StubInput(new String[]{"1", "6"});
        //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getDescription(), is("desc"));
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item item = tracker.add(new Item());
        Item item1 = tracker.add(new Item("name2", "desc2", 12L, comm));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getDescription(), is("desc2"));
    }

    @Test
    public void whenTheUserSearchesByID() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item item = tracker.add(new Item("name", "desc", 12L, comm));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("name"));
    }

    @Test
    public void whenTheUserSearchesForTheName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item item = tracker.add(new Item("name1", "desc2", 12L, comm));
        Item item1 = tracker.add(new Item("name3", "desc2", 123L, comm));
        Item item2 = tracker.add(new Item("name3", "desc2", 12L, comm));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"5", item1.getName(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[2].getName(), is("name3"));
    }
}

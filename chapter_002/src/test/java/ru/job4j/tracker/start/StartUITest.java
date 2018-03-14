package ru.job4j.tracker.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        String[] source = new String[]{"0", "test name", "desc", "y"};
        Input input = new StubInput(source);
        //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUserAddItemThenTrackerShowAllItemWithSameDesc() {
        Tracker tracker = new Tracker();     // создаём Tracker
        String[] comm = new String[10];
        String[] source = new String[]{"1", "y"};
        Item item = tracker.add(new Item("name", "desc", 1L, comm));
        Item item1 = tracker.add(new Item("name", "desc1", 1L, comm));
        Input input = new StubInput(source);
        //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(1).getDescription(), is("desc1"));
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        String[] source = new String[]{"2", item.getId(), "name", "desc", "y"};
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(source);
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("name"));
    }

    @Test
    public void whenDeleteThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item item = tracker.add(new Item());
        Item item1 = tracker.add(new Item("name2", "desc2", 12L, comm));
        String[] source = new String[]{"3", item.getId(), "y"};
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(source);
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll().get(0).getDescription(), is("desc2"));
    }

    @Test
    public void whenTheUserSearchesByID() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item item = tracker.add(new Item("name", "desc", 12L, comm));
        Item item1 = tracker.add(new Item("name1", "desc", 12L, comm));
        String[] source = new String[]{"4", item1.getId(), "y"};
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(source);
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll().get(0).getName(), is("name"));
    }

    @Test
    public void whenTheUserSearchesForTheName() {
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item item = tracker.add(new Item("name1", "desc2", 12L, comm));
        Item item1 = tracker.add(new Item("name3", "desc2", 123L, comm));
        Item item2 = tracker.add(new Item("name3", "desc2", 12L, comm));
        String[] source = new String[]{"5", item1.getName(), "y"};
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(source);
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findByName("name3").get(1).getName(), is("name3"));
    }
}
package ru.job4j.tracker.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final Tracker tracker = new Tracker();
    private final String[] comm = new String[10];

    private Item item = tracker.add(new Item("name", "desc", 12L, comm));
    private Item item1 = tracker.add(new Item("name", "desc2", 123L, comm));
    private Item item2 = tracker.add(new Item("name3", "desc3", 12L, comm));

    private Input input0 = new StubInput(new String[]{"0", "name", "desc", "6"});
    private Input input1 = new StubInput(new String[]{"1", "6"});
    private Input input2 = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
    private Input input3 = new StubInput(new String[]{"3", item.getId(), "6"});
    private Input input4 = new StubInput(new String[]{"4", item.getId(), "6"});
    private Input input5 = new StubInput(new String[]{"5", item1.getName(), "6"});
    String name = tracker.findAll()[0].getName();
    String id = tracker.findById(item.getId()).getName();

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
        new StartUI(input0, tracker).init();
        assertThat(name, is("name"));
    }

    @Test
    public void whenUserAddItemThenTrackerShowAllItemWithSameDesc() {
        new StartUI(input1, tracker).init();
        assertThat(name, is("name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        new StartUI(input2, tracker).init();
        assertThat(id, is("name"));
    }

    @Test
    public void whenDeleteThenTrackerHasUpdatedValue() {
        new StartUI(input3, tracker).init();
        assertThat(name, is("name"));
    }

    @Test
    public void whenTheUserSearchesByID() {
        new StartUI(input4, tracker).init();
        assertThat(id, is("name"));
    }

    @Test
    public void whenTheUserSearchesForTheName() {
        new StartUI(input5, tracker).init();
        assertThat(name, is("name"));
    }
}

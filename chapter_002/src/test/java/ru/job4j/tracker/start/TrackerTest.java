package ru.job4j.tracker.start;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 06.02.2018
 */
import ru.job4j.tracker.models.Item;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item item = new Item("test1", "testDescription", 123L, comm);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item previous = new Item("test1", "testDescription", 123L, comm);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L, comm);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenToDeleteCellArrayToReturnTheCorrected() {
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item itemOne = new Item("test1", "testDesc1", 1L, comm);
        Item itemTwo = new Item("test2", "testDesc2", 12L, comm);
        Item itemThree = new Item("test3", "testDesc3", 123L, comm);
        Item itemFour = new Item("test4", "testDesc4", 1234L, comm);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        tracker.delete(itemTwo.getId());
        Item[] res = {itemOne, itemThree, itemFour};
        assertThat(tracker.findAll(), is(res));
    }

    @Test
    public void whenWeCompareTheTwoNames() {
        Tracker tracker = new Tracker();
        String[] comm = new String[10];
        Item itemOne = new Item("test34", "testDesc1", 1L, comm);
        Item itemTwo = new Item("test2", "testDesc2", 12L, comm);
        Item itemThree = new Item("test3", "testDesc3", 123L, comm);
        Item itemFour = new Item("test3", "testDesc4", 1234L, comm);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        Item[] it = tracker.findByName("test3");
        Item[] res = {itemThree, itemFour};

        assertThat(it, is(res));
    }
}

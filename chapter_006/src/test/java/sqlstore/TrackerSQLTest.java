package sqlstore;

import org.junit.Test;
import ru.job4j.sqlstore.TrackerSQL;
import ru.job4j.tracker.models.Item;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 26.02.2019
 */
public class TrackerSQLTest {
    private static final Random RAND = new Random();

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RAND.nextInt());
    }

    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void checkTable() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.checkTableExist(), is(true));
    }

    @Test
    public void whenAddItem() {
        Date today = new Date();
        Item item = new Item("test", "testDescription", today.getTime(), "comm");
        Item item1 = new Item("test1", "testDescription1", today.getTime(), "comm1");
        Item item2 = new Item("test2", "testDescription2", today.getTime(), "comm2");
        item.setId(this.generateId());
        item1.setId(this.generateId());
        item2.setId(this.generateId());
        TrackerSQL sql = new TrackerSQL();
        sql.checkTableExist();
        sql.add(item);
        sql.add(item1);
        sql.add(item2);
        List<Item> list = sql.findAll();
        assertThat(list.get(0).getName(), is("test"));
        assertThat(list.get(1).getName(), is("test1"));
        assertThat(list.get(2).getName(), is("test2"));

//        whenFindItemByName
        List<Item> list1 = sql.findByName("test1");
        assertThat(list1.get(0).getComments(), is("comm1"));

//        whenFindItemById
        Item it = sql.findById("2");
        assertThat(it.getName(), is("test1"));

//        whenReplaceItem
        Item item3 = new Item("test3", "testDescription3", today.getTime(), "comm3");
        item3.setId(this.generateId());
        sql.replace("2", item3);
        List<Item> list2 = sql.findAll();
        assertThat(list2.get(2).getName(), is("test3"));

//        whenDeleteItem
        sql.delete("2");
        List<Item> list3 = sql.findAll();
        assertThat(list3.size(), is(2));
        try {
            sql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







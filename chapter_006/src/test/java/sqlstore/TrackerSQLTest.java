package sqlstore;

import org.junit.Test;
import ru.job4j.sqlstore.ConnectionRollback;
import ru.job4j.sqlstore.TrackerSQL;
import ru.job4j.tracker.models.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
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

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void checkTable() throws Exception {
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            assertThat(sql.checkTableExist(), is(true));
        }
    }

    @Test
    public void whenAddItem() throws Exception {
        Date today = new Date();
        Item item = new Item("test", "testDescription", today.getTime(), "comm");
        item.setId(this.generateId());
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.checkTableExist();
            sql.add(item);
            List<Item> list = sql.findAll();
            assertThat(list.get(0).getName(), is("test"));
        }
    }

    @Test
    public void whenFindItemByName() throws Exception {
        Date today = new Date();
        Item item = new Item("test", "testDescription", today.getTime(), "comm");
        Item item1 = new Item("test1", "testDescription1", today.getTime(), "comm1");
        Item item2 = new Item("test2", "testDescription2", today.getTime(), "comm2");
        item.setId(this.generateId());
        item1.setId(this.generateId());
        item2.setId(this.generateId());
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.checkTableExist();
            sql.add(item);
            sql.add(item1);
            sql.add(item2);
            List<Item> list1 = sql.findByName("test1");
            assertThat(list1.get(0).getComments(), is("comm1"));

        }
    }

    @Test
    public void whenFindItemById() throws Exception {
        Date today = new Date();
        Item item = new Item("test", "testDescription", today.getTime(), "comm");
        Item item1 = new Item("test1", "testDescription1", today.getTime(), "comm1");
        Item item2 = new Item("test2", "testDescription2", today.getTime(), "comm2");
        item.setId(this.generateId());
        item1.setId(this.generateId());
        item2.setId(this.generateId());
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.checkTableExist();
            sql.add(item);
            sql.add(item1);
            sql.add(item2);
            Item it = sql.findById("2");
            assertThat(it.getName(), is("test1"));
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        Date today = new Date();
        Item item = new Item("test", "testDescription", today.getTime(), "comm");
        Item item1 = new Item("test1", "testDescription1", today.getTime(), "comm1");
        Item item2 = new Item("test2", "testDescription2", today.getTime(), "comm2");
        Item item3 = new Item("test3", "testDescription3", today.getTime(), "comm3");
        item.setId(this.generateId());
        item1.setId(this.generateId());
        item2.setId(this.generateId());
        item3.setId(this.generateId());
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.checkTableExist();
            sql.add(item);
            sql.add(item1);
            sql.add(item2);
            sql.replace("2", item3);
            List<Item> list2 = sql.findAll();
            assertThat(list2.get(2).getName(), is("test3"));
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        Date today = new Date();
        Item item = new Item("test", "testDescription", today.getTime(), "comm");
        Item item1 = new Item("test1", "testDescription1", today.getTime(), "comm1");
        Item item2 = new Item("test2", "testDescription2", today.getTime(), "comm2");
        item.setId(this.generateId());
        item1.setId(this.generateId());
        item2.setId(this.generateId());
        try (TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            sql.checkTableExist();
            sql.add(item);
            sql.add(item1);
            sql.add(item2);
            sql.delete("2");
            List<Item> list = sql.findAll();
            assertThat(list.size(), is(2));
        }
    }
}

package ru.job4j.sqlstore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.ITracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 20.02.2019
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());
    private Connection connection;

    public TrackerSQL(Connection connection) {
        this.connection = connection;
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    public boolean checkTableExist() {
        boolean result = false;
        try {
            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet resultSet = metadata.getTables(null, null, "tracker", null);
            if (resultSet.next()) {
                return true;
            } else {
                PreparedStatement st = connection.prepareStatement("CREATE TABLE  tracker(id serial primary key, item_id varchar(50) , name varchar (30), description varchar (200), created_date timestamp, comment text );");
                st.executeUpdate();
                st.close();
                result = true;
            }
        } catch (SQLException e) {
            LOG.error("error message {}", "error in checkTableExist");
        }
        return result;
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement st = connection.prepareStatement("INSERT INTO tracker(item_id, name, description, created_date, comment) values (?, ?, ?, ?, ?);")) {
            st.setString(1, item.getId());
            st.setString(2, item.getName());
            st.setString(3, item.getDescription());
            st.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            st.setString(5, item.getComments());
            st.executeUpdate();
        } catch (Exception e) {
            LOG.error("error message {}", "error in  add method");
        }
        return item;
    }

    @Override
    public void replace(String id, Item item) {
        try (PreparedStatement st = connection.prepareStatement("UPDATE tracker SET item_id = ?, name = ?, description = ?, created_date = ?, comment = ? WHERE id = ?;")) {
            st.setString(1, item.getId());
            st.setString(2, item.getName());
            st.setString(3, item.getDescription());
            st.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            st.setString(5, item.getComments());
            st.setInt(6, Integer.parseInt(id));
            st.executeUpdate();
        } catch (Exception e) {
            LOG.error("error message {}", "error in  replace method");
        }
    }

    @Override
    public void delete(String id) {
        try (PreparedStatement st = connection.prepareStatement("DELETE FROM tracker WHERE id = ?;")) {
            st.setInt(1, Integer.parseInt(id));
            st.executeUpdate();
        } catch (Exception e) {
            LOG.error("error message {}", "error in  delete method");
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement("SELECT name, description, created_date, comment FROM tracker;")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp("created_date");
                long date = ts.getTime();
                list.add(new Item(rs.getString("name"), rs.getString("description"), date, rs.getString("comment")));
            }
            rs.close();
        } catch (Exception e) {
            LOG.error("error message {}", "error in  findAll method");
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement("SELECT name, description, created_date, comment FROM tracker WHERE name like ?;")) {
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp("created_date");
                long date = ts.getTime();
                list.add(new Item(rs.getString("name"), rs.getString("description"), date, rs.getString("comment")));
            }
            rs.close();
        } catch (Exception e) {
            LOG.error("error message {}", "error in  findByName method");
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        Item item = new Item();
        try (PreparedStatement st = connection.prepareStatement("SELECT name, description, created_date, comment FROM tracker WHERE id = ?;")) {
            st.setInt(1, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp("created_date");
                long date = ts.getTime();
                item = new Item(rs.getString("name"), rs.getString("description"), date, rs.getString("comment"));
            }
            rs.close();
        } catch (Exception e) {
            LOG.error("error message {}", "error in  findById method");
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }
}

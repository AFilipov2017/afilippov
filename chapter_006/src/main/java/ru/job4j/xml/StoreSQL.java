package ru.job4j.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 28.02.2019
 */
public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;
    private static final Logger LOG = LogManager.getLogger(StoreSQL.class.getName());

    public StoreSQL(Config config) {
        this.config = config;
        contact();
    }

    public boolean contact() {
        config.init();
        try {
            this.connect = DriverManager.getConnection(
                    config.get("url"),
                    config.get("username"),
                    config.get("password")
            );
            connect.setAutoCommit(false);
        } catch (SQLException e) {
            LOG.error("error message {}", "ошибка соединения");
        }
        return this.connect != null;
    }

    public void generate(int size) throws SQLException {
        checkTableExist();
        delete();
        try (PreparedStatement st = connect.prepareStatement("INSERT INTO entry(field) values (?);")) {
            for (int i = 0; i < size; i++) {
                st.setInt(1, i);
                st.addBatch();
            }
            st.executeBatch();
        } catch (Exception e) {
            LOG.error("error message {}", "error in add method");
            connect.rollback();
        }
    }

    public List<Entry> load() throws SQLException {
        List<Entry> list = new ArrayList<>();
        try (PreparedStatement st = connect.prepareStatement("SELECT * FROM entry;")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int res = rs.getInt("field");
                list.add(new Entry(res));
            }
            rs.close();
            connect.commit();
        } catch (Exception e) {
            LOG.error("error message {}", "error in  load method");
            connect.rollback();
        }
        return list;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    public void checkTableExist() throws SQLException {
        try {
            PreparedStatement st = connect.prepareStatement("CREATE TABLE IF NOT EXISTS  entry (field int);");
            st.executeUpdate();
            st.close();
            connect.commit();
        } catch (SQLException e) {
            LOG.error("error message {}", "error in checkTableExist");
            connect.rollback();
        }
    }

    public void delete() throws SQLException {
        try (PreparedStatement st = connect.prepareStatement("DELETE FROM entry;")) {
            st.executeUpdate();
            connect.commit();
        } catch (Exception e) {
            LOG.error("error message {}", "error in delete method");
            connect.rollback();
        }
    }
}

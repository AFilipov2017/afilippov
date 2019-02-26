package ru.job4j.sqlstore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 18.02.2019
 */
public class SQLstorage {

    private static final Logger LOG = LogManager.getLogger(SQLstorage.class.getName());

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/the_cars";
        String username = "postgres";
        String password = "password";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM cars as c where c.id in (?, ?)");
            st.setInt(1, 2);
            st.setInt(2, 4);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s %s", rs.getString("name"), rs.getString("bodywork_id")));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
}

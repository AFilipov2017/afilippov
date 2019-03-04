package ru.job4j.xml;

import java.io.InputStream;
import java.util.Properties;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 28.02.2019
 */
public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("store.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}

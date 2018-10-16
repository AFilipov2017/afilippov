package ru.job4j.additionaltask;

import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 03.10.2018
 */
public class Store<T extends Store.User> {
    private int count = 0;
    private int changed = 0;

    Info diff(List<T> previous, List<T> current) {
        Info a = new Info(0, 0, 0);
        previous.stream().forEach(n -> {
            if (current.contains(n)) {
                ++count;
            }
        });
        previous.stream().forEach(n -> current.forEach(m -> {
            if (m.id == n.id && !m.name.equals(n.name)) {
                a.setEdit(++changed);
            }
        }));
        a.setAdd(current.size() - count - changed);
        a.setDelete(previous.size() - count - changed);

        return a;
    }

    static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}

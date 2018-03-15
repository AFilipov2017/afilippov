package ru.job4j.comparator;

import java.util.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 15.03.2018
 */
public class SortUser {
    /**
     * Метод возвращает TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     *
     * @param list список имен и возраст.
     */
    public Set<User> sort(List<User> list) {
        Set<User> user = new TreeSet<>();
        user.addAll(list);
        return user;
    }

    /**
     * Метод сортирует пользователей по длине имени.
     *
     * @param list список имен и возрастов.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), (o2.getName().length()));
            }
        });
        return null;
    }

    /**
     * Метод сортирует пользователей по длине имени и по возрасту.
     *
     * @param list список имен и возрастов.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = Integer.compare(o1.getName().length(), (o2.getName().length()));

                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return null;
    }
}


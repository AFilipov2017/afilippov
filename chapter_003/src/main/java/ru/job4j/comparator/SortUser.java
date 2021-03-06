package ru.job4j.comparator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<User> user = list.stream().sorted((o1, o2) -> Integer.compare(o1.getName().length(), (o2.getName().length()))).collect(Collectors.toList());
        list.clear();
        list.addAll(user);
        return list;
    }

    /**
     * Метод сортирует пользователей по длине имени и по возрасту.
     *
     * @param list список имен и возрастов.
     */
    public List<User> sortByAllFields(List<User> list) {
        Stream<User> users = list.stream().sorted((o1, o2) -> {
            int result = o1.getName().compareTo(o2.getName());
            return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
        });
        List<User> user = users.collect(Collectors.toList());
        list.clear();
        list.addAll(user);
        return list;
    }
}



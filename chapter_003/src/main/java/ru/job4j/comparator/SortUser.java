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
     * @param list список имен и возрастов.
     */
    public Set<User> sort(List<User> list) {
        Set<User> user = new TreeSet<>();
        user.addAll(list);
        return user;
    }
}


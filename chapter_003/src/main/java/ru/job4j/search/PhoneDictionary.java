package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 11.02.2018
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> list = persons.stream().filter(n -> n.getName().contains(key)
                || n.getSurname().contains(key)
                || n.getPhone().contains(key)
                || n.getAddress().contains(key)).collect(Collectors.toList());
        return list;
    }
}

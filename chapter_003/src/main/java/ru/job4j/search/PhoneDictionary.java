package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 11.02.2018
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

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
        List<Person> result = new ArrayList<>();
        for (Person rez : persons) {
            if (key.contains(rez.getName()) || key.contains(rez.getSurname()) || key.contains(rez.getPhone()) || key.contains(rez.getAddress())) {
                result.add(rez);
            }
        }
        return result;
    }
}

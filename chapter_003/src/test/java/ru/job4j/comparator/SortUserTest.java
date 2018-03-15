package ru.job4j.comparator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1.0
 * @since 15.03.2018
 */
public class SortUserTest {
    @Test
    public void whenListSortedToSet() {
        SortUser user = new SortUser();
        List<User> list = Arrays.asList(new User("Ivan", 65), new User("Serg", 32), new User("Zwon", 25));
        Set<User> sort = user.sort(list);
        List<User> data = new ArrayList<>();
        data.addAll(sort);
        int result = data.get(0).getAge();
        assertThat(result, is(25));
    }

    @Test
    public void whenListSortedToSet2() {
        SortUser user = new SortUser();
        List<User> list = Arrays.asList(new User("Ivan", 82), new User("Sergo", 15), new User("Zelda", 32));
        Set<User> sort = user.sort(list);
        List<User> data = new ArrayList<>();
        data.addAll(sort);
        int result = data.get(2).getAge();
        assertThat(result, is(82));
    }

    @Test
    public void whenListSortedByNameLength() {
        SortUser user = new SortUser();
        List<User> list = new ArrayList<>(Arrays.asList(new User("Andrey", 25), new User("Alex", 30), new User("Veniamin", 33)));
        user.sortNameLength(list);
        String result = list.get(0).getName();
        assertThat(result, is("Alex"));
    }

    @Test
    public void whenListSortedByAllFields() {
        List<User> list = new ArrayList<>(Arrays.asList(new User("Andrey", 25), new User("Alex", 30), new User("Veniamin", 33)));
        List<User> list1 = new ArrayList<>(Arrays.asList(new User("Andrey", 30), new User("Alex", 31), new User("Veniamin", 29)));
        list.addAll(list1);
        SortUser sort = new SortUser();
        sort.sortByAllFields(list);
        int result = list.get(0).getAge();
        assertThat(result, is(30));
    }

    @Test
    public void whenListSortedByAllFieldsTwo() {
        List<User> list = new ArrayList<>(Arrays.asList(new User("Andrey", 25), new User("Alex", 30), new User("Veniamin", 33)));
        List<User> list1 = new ArrayList<>(Arrays.asList(new User("Andrey", 30), new User("Alex", 31), new User("Veniamin", 29)));
        list.addAll(list1);
        SortUser sort = new SortUser();
        sort.sortByAllFields(list);
        int result = list.get(5).getAge();
        assertThat(result, is(33));
    }

    @Test
    public void whenListSortedByAllFieldsThree() {
        List<User> list = new ArrayList<>(Arrays.asList(new User("Andrey", 25), new User("Alex", 30), new User("Veniamin", 33)));
        List<User> list1 = new ArrayList<>(Arrays.asList(new User("Andrey", 30), new User("Alex", 31), new User("Veniamin", 29)));
        list.addAll(list1);
        SortUser sort = new SortUser();
        sort.sortByAllFields(list);
        String result = list.get(5).getName();
        assertThat(result, is("Veniamin"));
    }
}

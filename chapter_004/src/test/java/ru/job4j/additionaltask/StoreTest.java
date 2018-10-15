package ru.job4j.additionaltask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 13.10.2018
 */
public class StoreTest {

    @Test
    public void whenWeAddNewUser() {
        List<Store.User> list = new ArrayList<>();
        list.add(new Store.User(1, "Andrey"));
        list.add(new Store.User(2, "Sergey"));
        list.add(new Store.User(3, "Nicolay"));
        list.add(new Store.User(4, "Vlad"));
        List<Store.User> list1 = new ArrayList<>();
        list1.addAll(list);
        list1.add(new Store.User(5, "Nicol"));
        Store store = new Store();
        Info map = store.diff(list, list1);
        int value = map.getMap().get("Added users");
        assertThat(value, is(1));
    }

    @Test
    public void whenWeDeletedAndAddUser() {
        List<Store.User> list = new ArrayList<>();
        list.add(new Store.User(1, "Andrey"));
        list.add(new Store.User(2, "Sergey"));
        list.add(new Store.User(3, "Nicolay"));
        list.add(new Store.User(4, "Vlad"));
        List<Store.User> list1 = new ArrayList<>();
        list1.addAll(list);
        list1.remove(0);
        list1.add(new Store.User(5, "Nicol"));
        Store store = new Store();
        Info map = store.diff(list, list1);
        int value = map.getMap().get("Added users");
        int value1 = map.getMap().get("Deleted users");
        assertThat(value, is(1));
        assertThat(value1, is(1));
    }

    @Test
    public void whenWeDeleteUser() {
        List<Store.User> list = new ArrayList<>();
        list.add(new Store.User(1, "Andrey"));
        list.add(new Store.User(2, "Sergey"));
        list.add(new Store.User(3, "Nicolay"));
        list.add(new Store.User(4, "Vlad"));
        List<Store.User> list1 = new ArrayList<>();
        list1.addAll(list);
        list1.remove(0);
        list1.remove(0);
        Store store = new Store();
        Info map = store.diff(list, list1);
        int value = map.getMap().get("Deleted users");
        assertThat(value, is(2));
    }

    @Test
    public void whenWeEditUser() {
        List<Store.User> list = new ArrayList<>();
        list.add(new Store.User(1, "Andrey"));
        list.add(new Store.User(2, "Serg"));
        list.add(new Store.User(3, "Nicol"));
        list.add(new Store.User(4, "Vlad"));
        List<Store.User> list1 = new ArrayList<>();
        list1.addAll(list);
        list1.set(0, new Store.User(1, "Sergey"));
        Store<Store.User> store = new Store<>();
        Info map = store.diff(list, list1);
        int value = map.getMap().get("Changed users");
        assertThat(value, is(1));
    }
}

package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since
 */
public class UserConvertTest {
    @Test
    public void whenListConvertToMap() {
        User user = new User(1, "name", "Moscow");
        User user1 = new User(2, "name2", "St.Peterburg");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> a = userConvert.process(list);
        String result = a.get(2).getName();
        assertThat(result, is("name2"));
    }

    @Test
    public void whenListConvertToMap2() {
        User user = new User(1, "name1", "Moscow");
        User user1 = new User(2, "name2", "St.Peterburg");
        User user2 = new User(3, "name3", "RostovNaDonu");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> a = userConvert.process(list);
        String result = a.get(1).getCity();
        assertThat(result, is("Moscow"));
    }
}

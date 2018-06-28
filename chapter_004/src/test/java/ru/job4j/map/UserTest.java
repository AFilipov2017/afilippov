package ru.job4j.map;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 28.06.2018
 */
public class UserTest {

    @Test
    public void notOverrideHashCode() {
        User user = new User("Alex", 2, new GregorianCalendar(1980, 05, 02));
        User userTwo = new User("Alex", 2, new GregorianCalendar(1980, 05, 02));
        Map<User, Object> map = new HashMap<>();

        map.put(user, new Object());
        map.put(userTwo, new Object());
        System.out.println(map);
        boolean result = user.equals(userTwo);
        assertThat(result, is(true));
    }
}

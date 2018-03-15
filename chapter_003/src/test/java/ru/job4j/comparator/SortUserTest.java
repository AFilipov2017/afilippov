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
 * @version 1
 * @since
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
}

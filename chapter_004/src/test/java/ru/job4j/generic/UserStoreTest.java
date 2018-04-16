package ru.job4j.generic;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since
 */
public class UserStoreTest {
    @Test
    public void whenAddObject() {
        User user = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        UserStore userStore = new UserStore();
        userStore.add(user);
        userStore.add(user2);
        userStore.add(user3);
        User result = userStore.getModel(0);
        assertThat(result, is(user));
    }

    @Test
    public void whenReplaceModel() {
        User user = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        UserStore userStore = new UserStore();
        userStore.add(user);
        userStore.add(user2);
        userStore.replace("2", user3);
        User result = userStore.getModel(1);
        assertThat(result, is(user3));
    }

    @Test
    public void whenDeleteById() {
        User user = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        UserStore userStore = new UserStore();
        userStore.add(user);
        userStore.add(user2);
        userStore.add(user3);
        userStore.delete("2");
        User result = userStore.getModel(1);
        assertThat(result, is(user3));
    }

    @Test
    public void whenFindById() {
        User user = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        UserStore userStore = new UserStore();
        userStore.add(user);
        userStore.add(user2);
        userStore.add(user3);
        User result = userStore.findById("2");
        assertThat(result, is(user2));
    }
}

package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since
 */
public class RoleStoreTest {

    @Test
    public void whenAddObject() {
        Role role = new Role("1");
        Role role2 = new Role("2");
        Role role3 = new Role("3");
        RoleStore roleStore = new RoleStore();
        roleStore.add(role);
        roleStore.add(role2);
        roleStore.add(role3);
        Base result = roleStore.getModel(0);
        assertThat(result, is(role));
    }

    @Test
    public void whenReplaceModel() {
        Role role = new Role("1");
        Role role2 = new Role("2");
        Role role3 = new Role("3");
        RoleStore roleStore = new RoleStore();
        roleStore.add(role);
        roleStore.add(role2);
        roleStore.replace("2", role3);
        Base result = roleStore.getModel(1);
        assertThat(result, is(role3));
    }

    @Test
    public void whenDeleteById() {
        Role role = new Role("1");
        Role role2 = new Role("2");
        Role role3 = new Role("3");
        RoleStore roleStore = new RoleStore();
        roleStore.add(role);
        roleStore.add(role2);
        roleStore.add(role3);
        roleStore.delete("2");
        Base result = roleStore.getModel(1);
        assertThat(result, is(role3));
    }

    @Test
    public void whenFindById() {
        Role role = new Role("1");
        Role role2 = new Role("2");
        Role role3 = new Role("3");
        RoleStore roleStore = new RoleStore();
        roleStore.add(role);
        roleStore.add(role2);
        roleStore.add(role3);
        Base result = roleStore.findById("2");
        assertThat(result, is(role2));
    }
}


package ru.job4j.additionaltask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 07.08.2018
 */
public class CoffeeMachineTest {
    @Test
    public void whenChangeCash() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Integer[] result = coffeeMachine.changes(50, 35);
        assertThat(result, is(new Integer[]{10, 5}));
    }

    @Test
    public void whenChangeCashTwo() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Integer[] result = coffeeMachine.changes(100, 21);
        assertThat(result, is(new Integer[]{10, 10, 10, 10, 10, 10, 10, 5, 2, 2}));
    }

    @Test
    public void whenChangeCashThree() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Integer[] result = coffeeMachine.changes(50, 13);
        assertThat(result, is(new Integer[]{10, 10, 10, 5, 2}));
    }

    @Test
    public void whenChangeCashFour() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Integer[] result = coffeeMachine.changes(75, 32);
        assertThat(result, is(new Integer[]{10, 10, 10, 10, 2, 1}));
    }
}

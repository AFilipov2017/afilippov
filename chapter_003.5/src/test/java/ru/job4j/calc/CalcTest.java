package ru.job4j.calc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 24.09.2018
 */
public class CalcTest {
    @Test
    public void whenWeCalculateTheLinearFunction() {
        Calc c = new Calc();
        List<Double> list = new ArrayList<>();
        list.add(5.0);
        list.add(8.0);
        list.add(11.0);
        List<Double> result = c.diapason(1, 3, (n) -> 3 * n + 2);
        assertThat(result, is(list));
    }

    @Test
    public void whenWeCalculateTheQuadraticFunction() {
        Calc c = new Calc();
        List<Double> list = new ArrayList<>();
        list.add(9.0);
        list.add(18.0);
        list.add(31.0);
        List<Double> result = c.diapason(1, 3, (n) -> 2 * Math.pow(n, 2) + (3 * n) + 4);
        assertThat(result, is(list));
    }

    @Test
    public void whenWeCalculateTheLogarithmicFunction() {
        Calc c = new Calc();
        List<Double> list = new ArrayList<>();
        list.add(Math.log(1));
        list.add(Math.log(2));
        list.add(Math.log(3));
        List<Double> result = c.diapason(1, 3, (n) -> Math.log(n));
        assertThat(result, is(list));
    }
}

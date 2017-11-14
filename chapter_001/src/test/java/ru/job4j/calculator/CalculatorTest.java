package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void whenADDOnePlusOneThenOne() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }


    @Test
    public void whenSubtractOneSubOneThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(1D, 1D);
        double result = calc.getRes1();
        double expected = 0D;
        assertThat(result, is(expected));
    }

    public void whenDivOneDivOneThenOne() {
        Calculator calc = new Calculator();
        calc.div(1D, 1D);
        double result = calc.getRes2();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    public void whenMultiOneMultiOneThenOne() {
        Calculator calc = new Calculator();
        calc.multiple(1D, 1D);
        double result = calc.getRes3();
        double expected = 1D;
        assertThat(result, is(expected));
    }


}
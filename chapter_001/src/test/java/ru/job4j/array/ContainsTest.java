package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainsTest {
    @Test
    public void checkThatTheWordIsInTheWord() {
        String origin = "Привет";
        String sub = "иве";
        Contains word = new Contains();
        boolean result = word.contains(origin, sub);
        assertThat(result, is(true));
    }
}

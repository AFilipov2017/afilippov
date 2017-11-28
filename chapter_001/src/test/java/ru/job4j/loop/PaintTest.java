package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^ %1$s^^^%1$s", System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint paint = new Paint();
        String result = paint.piramid(3);
        String expected = String.format("  ^  %1$s ^^^ %1$s^^^^^%1$s", System.getProperty("line.separator"));
        assertThat(result, is(expected));
        //напишите здесь тест, проверяющий формирование пирамиды для высоты 3.
    }
}



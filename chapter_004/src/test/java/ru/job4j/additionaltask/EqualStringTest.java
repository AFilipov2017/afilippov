package ru.job4j.additionaltask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 12.09.2018
 */
public class EqualStringTest {

    @Test
    public void whenToCompareTwoDifferentStrings() {
        EqualString eqs = new EqualString();
        String o = "mama";
        String t = "amam";
        boolean result = eqs.equalsString(o, t);
        assertThat(result, is(true));
    }

    @Test
    public void whenToCompareTwoSameStrings() {
        EqualString eqs = new EqualString();
        String o = "mama";
        String t = "mama";
        boolean result = eqs.equalsString(o, t);
        assertThat(result, is(true));
    }

    @Test
    public void whenToCompareTwoDifferentLengthStrings() {
        EqualString eqs = new EqualString();
        String o = "maman";
        String t = "mama";
        boolean result = eqs.equalsString(o, t);
        assertThat(result, is(false));
    }
}

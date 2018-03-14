package ru.job4j.tracker.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        List<String> list = new ArrayList<>();
        list.add("invalid");
        list.add("1");
        List<Integer> range = new ArrayList<>();
        range.add(1);

        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.ask("Enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter validate data again.%n")
                )
        );
    }
}

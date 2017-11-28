package ru.job4j.array;

        import org.junit.Test;

        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] resultArray = turn.back(new int[] {3, 5, 1, 4});
        int[] expectArray = new int[] {4, 1, 5, 3};
        assertThat(resultArray, is(expectArray));

    }
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] resultArray = turn.back(new int[] {1, 2, 3, 4, 5});
        int[] expectArray = new int[] {5, 4, 3, 2, 1};
        assertThat(resultArray, is(expectArray));

    }
}
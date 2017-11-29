package ru.job4j.array;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 20.11.2017
 */

public class BubbleSort {
    /**
     * Алгоритм проходит массив от начала и до конца,
     * сравнивая попарно соседние элементы,
     * если элементы стоят в неправильном порядке,
     * то они меняются местами
     * @param  array
     * @return возвращает измененный массив
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}

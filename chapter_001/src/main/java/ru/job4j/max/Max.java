package ru.job4j.max;

/**
 * @author afilippov
 * @version 1
 * @since 14.11.2017
 */

public class Max {
    /**
     * Maximum.
     * @param first, second, third.
     */
    public int max(int first, int second) {

        return first > second ? first : second;
    }
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
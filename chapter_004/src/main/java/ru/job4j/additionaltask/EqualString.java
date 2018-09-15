package ru.job4j.additionaltask;

import java.util.Arrays;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 12.09.2018
 */
public class EqualString {

    public boolean equalsString(String o, String t) {
        int size = Integer.min(o.length(), t.length());
        boolean result = true;
        if (o == t) {
            return true;
        }
        if (o.length() != t.length()) {
            result = false;
        } else {
            char[] one = o.toCharArray();
            char[] two = t.toCharArray();
            Arrays.sort(one);
            Arrays.sort(two);

            for (int i = 0; i < size; i++) {
                if (one[i] != two[i]) {
                    result = false;
                }
            }
        }
        return result;
    }
}

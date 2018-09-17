package ru.job4j.additionaltask;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 12.09.2018
 */
public class EqualString {

    public boolean equalsString(String o, String t) {
        boolean result = true;
        if (o == t) {
            return true;
        }
        if (o.length() != t.length()) {
            result = false;
        } else {
            Map<Character, Object> mpOne = new HashMap<>();
            Map<Character, Object> mpTwo = new HashMap<>();
            for (int i = 0; i < o.length(); i++) {
                mpOne.put(o.toCharArray()[i], null);
                mpTwo.put(t.toCharArray()[i], null);
            }
            if (!mpOne.equals(mpTwo)) {
                result = false;
            }
        }
        return result;
    }
}

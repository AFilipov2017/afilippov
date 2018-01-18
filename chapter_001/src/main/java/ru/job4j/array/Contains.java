package ru.job4j.array;


import java.util.Arrays;

public class Contains {
    boolean contains(String origin, String sub) {
        char[] one = origin.toCharArray();
        char[] two = sub.toCharArray();
        char[] three = new char[two.length];
        int a = 0;
        for (int i = 0; i < two.length - 1; i++) {
            for (int j = a; j < one.length - 1; j++) {
                if (two[i] == one[j] && two[i + 1] == one[j + 1]) {
                    three[i] = one[j];
                    a = ++j;
                    break;
                }
            }
        }
        if (two[two.length - 1] == one[a]) {
            three[three.length - 1] = one[a];
        }
        return Arrays.equals(two, three);
    }
}





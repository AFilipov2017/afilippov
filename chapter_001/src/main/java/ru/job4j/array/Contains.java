package ru.job4j.array;


import java.util.Arrays;

public class Contains {
    static boolean contains(String origin, String sub) {

        char[] one = origin.toCharArray();
        char[] two = sub.toCharArray();
        char[] three = new char[two.length];
        int a = 0;
        int arrTwolenght = two.length;
        int arrOnelenght = one.length;
        for (int i = 0; i < arrTwolenght - 1; i++) {
            for (int j = a; j < arrOnelenght - 1; j++) {
                if (two[i] == one[j] && two[i + 1] == one[j + 1]) {
                    three[i] = one[j];
                    a = ++j;
                    break;
                }
            }
        }
        return Arrays.equals(two, three);
    }
}




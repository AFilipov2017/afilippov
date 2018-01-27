package ru.job4j.array;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 20.01.2018
 */


public class Contains {
    /**
     * Проверяет, содержится ли подстрока в строке
     *
     * @param origin строка
     * @param sub    подстрока
     * @return true, если содержится; false иначе
     */
    public boolean contains(String origin, String sub) {
        char[] origArr = origin.toCharArray();
        char[] subArr = sub.toCharArray();
        int j = 0;
        boolean result = false;
        for (int i : origArr) {
            if (i == subArr[j]) {
                if (j == subArr.length - 1) {
                    result = true;
                    break;
                }
                j++;
                result = true;
            } else {
                j = 0;
                result = false;
            }
        }
             return result;
    }
}





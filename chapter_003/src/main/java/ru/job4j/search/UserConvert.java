package ru.job4j.search;

import java.util.HashMap;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 14.03.2018
 */
public class UserConvert {
    /**
     * Метод преобразует List в Map.
     *
     * @param list список юзеров.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User i : list) {
            map.put(i.getId(), i);
        }
        return map;
    }
}

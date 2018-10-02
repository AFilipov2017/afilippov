package ru.job4j.search;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

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
        Stream<User> user = list.stream();
        Iterator<User> split = user.iterator();
        split.forEachRemaining(n -> map.put(n.getId(), n));
        return map;
    }
}

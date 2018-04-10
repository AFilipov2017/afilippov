package ru.job4j.iterator;

import java.util.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 8.04.2018
 */

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> index = it.next();

            @Override
            public boolean hasNext() {
                if (index.hasNext()) {
                     return true;
                 }else{
                if(it.hasNext()){
                    index = it.next();
                }}
                return index.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return index.next();
            }
        };
    }
}

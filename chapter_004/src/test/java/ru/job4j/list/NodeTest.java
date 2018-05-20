package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 20.05.2018
 */
public class NodeTest {
    @Test
    public void whenLinkedListIsLooped() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);
        boolean result = first.hasCycle(first);
        assertThat(result, is(true));
    }

    @Test
    public void whenLinkedListIsLoopedInTheMiddle() {
        Node<String> first = new Node<>("1");
        Node<String> two = new Node<>("2");
        Node<String> third = new Node<>("3");
        Node<String> four = new Node<>("4");
        first.setNext(two);
        two.setNext(four);
        third.setNext(two);
        four.setNext(third);
        boolean result = first.hasCycle(first);
        assertThat(result, is(true));
    }

    @Test
    public void whenLinkedListIsNotLooped() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(null);
        boolean result = first.hasCycle(first);
        assertThat(result, is(false));
    }
}

package ru.job4j.additionaltask;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 14.09.2018
 */
public class TrieTest {

    @Test
    public void whenAddStringToTrie() {
        Trie trie = new Trie();
        trie.put("hello");
        boolean result = trie.contains("hello");
        assertThat(result, is(true));
    }

    @Test
    public void findStringAtTrie() {
        Trie trie = new Trie();
        trie.put("Mendeleev");
        trie.put("Mendel");
        trie.put("Maxwell");
        boolean result = trie.contains("Mendel");
        boolean resTwo = trie.contains("Maxwell");
        assertThat(result, is(true));
        assertThat(resTwo, is(true));
    }

    @Test
    public void findStringAtTrieTwo() {
        Trie trie = new Trie();
        trie.put("Pavlov");
        trie.put("Einstain");
        trie.put("Turing");
        boolean result = trie.contains("Fraud");
        assertThat(result, is(false));
    }

    @Test
    public void whenRemoveStringFromTrie() {
        Trie trie = new Trie();
        trie.put("Hello");
        trie.put("hElloween");
        boolean result = trie.contains("hello");
        trie.remove("hello");
        boolean resultTwo = trie.contains("hello");
        boolean resultThree = trie.contains("helloween");
        assertThat(result, is(true));
        assertThat(resultTwo, is(false));
        assertThat(resultThree, is(true));
    }

    @Test
    public void whenRemoveStringFromTrieTwo() {
        Trie trie = new Trie();
        trie.put("Maxwell");
        boolean result = trie.contains("Maxwell");
        trie.remove("Max");
        boolean resultTwo = trie.remove("Max");
        assertThat(result, is(true));
        assertThat(resultTwo, is(false));
    }

    @Test
    public void showKeyOfFirstLevel() {
        Trie trie = new Trie();
        trie.put("Almaty");
        trie.put("London");
        trie.put("Moscow");
        Set<Character> result = trie.getChild();
        Set<Character> set = new TreeSet<>();
        set.add('a');
        set.add('l');
        set.add('m');
        assertThat(result, is(set));
    }
}

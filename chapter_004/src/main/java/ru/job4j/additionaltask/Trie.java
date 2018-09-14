package ru.job4j.additionaltask;


import java.util.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 14.09.2018
 */
public class Trie {

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public Set<Character> getChild() {
        return root.getChildren();
    }

    static class Node {
        private Map<Character, Node> children;
        private boolean leaf;

        public Node() {
            this.children = new TreeMap<>();
            this.leaf = false;
        }

        public Set<Character> getChildren() {
            return children.keySet();
        }
    }

    public void put(String string) {
        Node node = root;
        for (char ch : string.toLowerCase().toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Node());
            }
            node = node.children.get(ch);
        }
        node.leaf = true;
    }

    public boolean contains(String string) {
        Node node = root;
        boolean result = true;
        for (char ch : string.toLowerCase().toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        if (!node.leaf) {
            result = false;
        }
        return result;
    }

    public boolean remove(String string) {
        Node node = root;
        boolean result;
        if (!contains(string)) {
            result = false;
        } else {
            for (char ch : string.toLowerCase().toCharArray()) {
                node = node.children.get(ch);
            }
            node.leaf = false;
            result = true;
        }
        return result;
    }
}

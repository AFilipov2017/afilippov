package ru.job4j.map;

import java.util.*;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 03.07.2018
 */
public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node> {
    private Node<K, V>[] hashTable;
    private float limit;
    private int modCount = 0;
    private int size = 0;

    public SimpleHashMap() {
        hashTable = new Node[16];
        limit = hashTable.length * 0.75f;
    }

    public int hash(K key) {
        int hash = 17;
        hash = (hash * 31 + key.hashCode() % hashTable.length) % hashTable.length;
        return Math.abs(hash);
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        if (size + 1 >= limit) {
            limit *= 2;
            arrayDouble();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if (hashTable[index] == null) {
            simpleAdd(index, newNode);
            modCount++;
            result = true;
        } else {

            List<Node<K, V>> list = hashTable[index].getNodes();
            for (Node<K, V> node : list) {
                if (node.getKey() == key) {
                    result = false;
                } else {
                    list.add(newNode);
                    size++;
                    modCount++;
                    result = true;
                }
            }
        }
        return result;
    }

    public V get(K key) {
        int index = hash(key);
        V value = null;
        if (index > hashTable.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (hashTable[index] == null) {
            throw new NullPointerException();
        }
        List<Node<K, V>> list = hashTable[index].getNodes();
        for (Node<K, V> node : list) {
            if (key.equals(node.getKey())) {
                value = node.getValue();
            }
        }
        return value;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = hash(key);
        if (hashTable[index] == null) {
            result = false;
        }
        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index] = null;
            modCount++;
            size -= 1;
            result = true;
        } else {
            List<Node<K, V>> list = hashTable[index].getNodes();
            for (Node<K, V> node : list) {
                if (key.equals(node.getKey())) {
                    list.remove(node);
                    modCount++;
                    size -= 1;
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    public void arrayDouble() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    public Node<K, V>[] getHashTable() {
        return hashTable;
    }

    public int getSize() {
        return size;
    }

    public class Node<K, V> {
        private List<Node<K, V>> nodes;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.nodes = new LinkedList<>();
            this.key = key;
            this.value = value;
        }

        public List<Node<K, V>> getNodes() {
            return nodes;
        }

        public void setNodes(List<Node<K, V>> nodes) {
            this.nodes = nodes;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {

            return Objects.hash(key, value);
        }
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            int pos = 0;
            int currentNodeNumber = 0;
            int expectedModCount = modCount;
            Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (currentNodeNumber == size) {
                    return false;
                }
                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveToNext()) {
                        subIterator = hashTable[pos].getNodes().iterator();
                    } else {
                        return false;
                    }
                }
                return subIterator.hasNext();
            }

            private boolean moveToNext() {
                do {
                    pos++;
                } while (pos < hashTable.length - 1 && hashTable[pos] == null);

                return pos < hashTable.length - 1 && hashTable[pos] != null;
            }

            @Override
            public Node next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                currentNodeNumber++;
                return subIterator.next();
            }
        };
    }
}


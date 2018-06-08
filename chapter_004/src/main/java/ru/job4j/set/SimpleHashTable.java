package ru.job4j.set;


import java.util.*;


/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 29.05.2018
 */
public class SimpleHashTable<E> implements Iterable<E> {
    private int defaultSize = 15;
    private Object[] hashTable;
    private int modCount = 0;
    private int hash;
    private int newHash;
    private int size = 0;


    public SimpleHashTable() {
        this.hashTable = new Object[defaultSize];
    }


    public int hash(E e) {
        hash = 31;
        hash = hash * 17 + e.hashCode() % hashTable.length;
        return Math.abs(hash);
    }

    public void add(E e) {
        checkTheSizeArray();
        newHash = hash(e) % hashTable.length;
        hashTable[newHash] = e;
        size++;
        modCount++;
    }

    public E getByKey(E e) {
        E value;
        int index = getIndex(e);
        value = (E) hashTable[index];
        return value;
    }

    public int getIndex(E e) {
        int index = -1;
        for (int i = 0; i < hashTable.length; i++) {
            if (e.equals(hashTable[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean remove(E e) {
        boolean result = false;
        for (int i = 0; i < hashTable.length; i++) {
            if (e.equals(hashTable[i])) {
                hashTable[i] = null;
                result = true;
                break;
            }
        }
        size--;
        modCount++;
        return result;
    }


    public void checkTheSizeArray() {
        int minSize = defaultSize;
        if (hash >= minSize) {
            this.defaultSize = minSize * 3 / 2;
            this.hashTable = Arrays.copyOf(hashTable, defaultSize);
        }
    }

    public E getNext(E e) {
        E value = null;
        for (int index = getIndex(e) + 1; index < hashTable.length; index++) {
            if (hashTable[index] != null) {
                value = (E) hashTable[index];
                break;
            }
        }
        return value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int pos = 0;
            int currentNodeNumber = 0;
            E currentNode;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return size > currentNodeNumber;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                for (; currentNodeNumber != size; pos++) {
                    if (hashTable[pos] != null) {
                        if (currentNode == null) {
                            currentNode = (E) hashTable[pos];
                        }
                        currentNodeNumber++;
                        E value = currentNode;
                        currentNode = getNext(currentNode);
                        return value;
                    }
                }
                return null;
            }
        };
    }
}


package ru.job4j.list;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 20.05.2018
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasCycle(Node<T> first) {
        Node<T> slow = first;
        Node<T> fast = first;
        boolean result = false;

        while (!result) {
            slow = slow.next;
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                result = false;
                break;
            }
            if (slow == fast) {
                result = true;
            }
        }
        return result;
    }
}


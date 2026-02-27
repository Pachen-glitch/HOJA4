package main.java.structure;

import main.java.domain.AbstractList;

public class DoublyLinkedList<T> extends AbstractList<T> {

    private static class Node<T> {
        T data;
        Node<T> next, prev;
        Node(T data) { this.data = data; }
    }

    private Node<T> tail;

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Lista vacía");
        T value = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        count--;
        return value;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new RuntimeException("Lista vacía");
        return tail.data;
    }
}
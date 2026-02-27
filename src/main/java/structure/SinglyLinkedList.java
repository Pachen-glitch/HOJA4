package main.java.structure;

import main.java.domain.AbstractList;

public class SinglyLinkedList<T> extends AbstractList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        count++;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Lista vacía");

        if (head.next == null) {
            T value = head.data;
            head = null;
            count--;
            return value;
        }

        Node<T> temp = head;
        while (temp.next.next != null) temp = temp.next;

        T value = temp.next.data;
        temp.next = null;
        count--;
        return value;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new RuntimeException("Lista vacía");
        Node<T> temp = head;
        while (temp.next != null) temp = temp.next;
        return temp.data;
    }
}
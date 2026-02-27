package main.java.domain;

public interface Stack<T> {
    void push(T value);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
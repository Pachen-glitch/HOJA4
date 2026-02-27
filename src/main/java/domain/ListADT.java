package main.java.domain;

public interface ListADT<T> {
    void add(T value);
    T removeLast();
    T getLast();
    boolean isEmpty();
    int size();
}
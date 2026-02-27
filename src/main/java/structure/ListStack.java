package main.java.structure;

import main.java.domain.AbstractStack;
import main.java.domain.ListADT;

public class ListStack<T> extends AbstractStack<T> {

    private ListADT<T> list;

    public ListStack(ListADT<T> list) {
        this.list = list;
    }

    @Override
    public void push(T value) {
        list.add(value);
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        count--;
        return list.removeLast();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        return list.getLast();
    }
}
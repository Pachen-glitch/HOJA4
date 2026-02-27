package main.java.structure;

import main.java.domain.AbstractStack;
import java.util.ArrayList;

public class ArrayListStack<T> extends AbstractStack<T> {

    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void push(T value) {
        list.add(value);
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        count--;
        return list.remove(count);
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        return list.get(count - 1);
    }
}
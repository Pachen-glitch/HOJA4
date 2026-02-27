package main.java.structure;

import main.java.domain.AbstractStack;
import java.util.Vector;

public class VectorStack<T> extends AbstractStack<T> {

    private Vector<T> vector = new Vector<>();

    @Override
    public void push(T value) {
        vector.add(value);
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        count--;
        return vector.remove(count);
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        return vector.get(count - 1);
    }
}
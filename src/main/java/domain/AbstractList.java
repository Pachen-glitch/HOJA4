package main.java.domain;

public abstract class AbstractList<T> implements ListADT<T> {
    protected int count;

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
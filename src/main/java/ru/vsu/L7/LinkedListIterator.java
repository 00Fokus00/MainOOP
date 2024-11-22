package ru.vsu.L7;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {

    private ExampleNode<T> current;

    public LinkedListIterator(ExampleNode<T> head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()){
            throw new IllegalStateException("No more elements");
        }
        T value = current.getValue();
        current = current.getNext();
        return value;
    }
}

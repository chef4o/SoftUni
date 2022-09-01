package implementations;

import java.util.Iterator;

public class ReversedList<E> {
    private static final int INITIAL_CAPACITY = 2;

    private Object[] elements;
    private int size;
    private int capacity;

    public ReversedList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(E element) {
        if (this.size == this.capacity) {
            grow();
        }
        this.elements[this.size] = element;
        size++;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public void removeAt(int index) {
        validate(index);

        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.size--;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = capacity - size;

            @Override
            public boolean hasNext() {
                return this.index < capacity;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        validate(index);
        return (E) this.elements[this.size - 1 - index];
    }

    private void grow() {

        Object[] growArray = new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++) {
            growArray[i] = this.elements[i];
        }

        this.capacity *= 2;
        this.elements = growArray;
    }

    private void validate(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + this.size);
        }
    }

}


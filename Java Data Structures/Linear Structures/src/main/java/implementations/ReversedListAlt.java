package implementations;

import java.util.Iterator;

public class ReversedListAlt<E> {
    private static final int INITIAL_CAPACITY = 2;

    private Object[] elements;
    private int size;
    private int capacity;

    public ReversedListAlt() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }


    public boolean add(E element) {
        reviseElementsCapacity();
        size++;
        this.elements[this.capacity - this.size] = element;
        return true;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public E removeAt(int index) {
        int actualIndex = this.capacity - 1 - index;
        E deletedElement = get(actualIndex);
        transmuteCurrentObject(actualIndex);

        if (this.size - 1 > 0) {
            this.size--;
        } else {
            this.size = 0;
        }

        reviseElementsCapacity();
        return deletedElement;
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
        return (E) this.elements[this.capacity - 1 - index];
    }

    private void reviseElementsCapacity() {
        if (this.size < INITIAL_CAPACITY
                || (this.size != this.capacity && this.size != this.capacity / 2)) {
            return;
        }

        if (this.size == this.capacity) {
            this.capacity *= 2;
            reloadData();
        }
    }

    private void reloadData() {
        Object[] tempElements = new Object[this.capacity];

        int tempIndex = this.capacity - 1;
        for (int i = this.size - 1; i >= 0; i--) {
            tempElements[tempIndex--] = this.elements[i];
        }

        this.elements = tempElements;
        tempElements = null;
    }

    private void transmuteCurrentObject(int startIndex) {
        String action = Thread.currentThread().getStackTrace()[2].getMethodName();

        switch (action) {
            //move elements to the left
            case "removeAt": {
                for (int i = startIndex; i >= this.capacity - this.size; i--) {
                    this.elements[i] = this.elements[i - 1];
                }
                this.elements[this.capacity - this.size] = null;
                break;
            }
            //move elements to the right
            case "add": {
                for (int i = this.capacity - this.size; i < startIndex; i++) {
                    this.elements[i - 1] = this.elements[i];
                }
                break;
            }
        }
    }

    private void validate(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + this.size);
        }
    }

}


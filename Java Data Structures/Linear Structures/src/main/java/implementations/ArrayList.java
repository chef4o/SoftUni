package implementations;

import interfaces.List;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_SIZE = 4;

    private Object[] elements;
    private int size;
    private int capacity;

    public ArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
        this.capacity = INITIAL_SIZE;
    }

    @Override
    public boolean add(E element) {
        reviseElementsCapacity();
        this.elements[this.size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        validate(index);
        reviseElementsCapacity();
        transmuteCurrentObject(index);
        this.elements[index] = element;
        this.size++;
        return true;
    }

    @Override
    public E get(int index) {
        validate(index);
        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        validate(index);
        E result = (E) this.elements[index];
        this.elements[index] = element;
        return result;
    }

    @Override
    public E remove(int index) {
        validate(index);
        E deletedElement = (E) this.elements[index];
        transmuteCurrentObject(index);

        if (this.size - 1 > 0) {
            this.size--;
        } else {
            this.size = 0;
        }

        reviseElementsCapacity();
        return deletedElement;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void insert(int index, E element) {
        this.add(index, element);
    }

    private void reviseElementsCapacity() {
        if (this.size < INITIAL_SIZE
                || (this.size != this.capacity && this.size != this.capacity / 2)) {
            return;
        }

        if (this.size == this.capacity) {
            this.capacity *= 2;
        } else if (this.size > INITIAL_SIZE && this.size + 1 == this.capacity / 2) {
            this.capacity /= 2;
        }

        reloadData();
    }

    private void reloadData() {
        Object[] tempElements = new Object[this.capacity];

        for (int i = 0; i < this.size; i++) {
            tempElements[i] = this.elements[i];
        }

        this.elements = tempElements;
        tempElements = null;
    }

    private void transmuteCurrentObject(int startIndex) {
        String action = Thread.currentThread().getStackTrace()[2].getMethodName();

        switch (action) {
            //move elements to the left
            case "remove": {
                for (int i = startIndex; i < this.size; i++) {
                    this.elements[i] = this.elements[i + 1];
                }
                this.elements[this.size - 1] = null;
                break;
            }
            //move elements to the right
            case "add": {
                for (int i = this.size - 1; i >= startIndex; i--) {
                    this.elements[i + 1] = this.elements[i];
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


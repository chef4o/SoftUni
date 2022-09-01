package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {

    private final int INITIAL_CAPACITY = 7;
    private int headIndex;
    private int tailIndex;
    private int size;
    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[INITIAL_CAPACITY];
        headIndex = tailIndex = INITIAL_CAPACITY / 2;
    }

    @Override
    public void add(E element) {
        this.addLast(element);
    }

    @Override
    public void offer(E element) {
        this.addLast(element);
    }

    @Override
    public void addFirst(E element) {
        if (this.size == 0) {
            this.addLast(element);
        } else {
            if (this.headIndex == 0) {
                this.elements = grow();
            }
            this.elements[--this.headIndex] = element;
            this.size++;
        }
    }

    @Override
    public void addLast(E element) {
        if (this.size == 0) {
            this.elements[this.tailIndex] = element;
        } else {
            if (this.tailIndex == this.elements.length - 1) {
                this.elements = grow();
            }
            this.elements[++this.tailIndex] = element;
        }
        this.size++;
    }

    @Override
    public void push(E element) {
        addFirst(element);
    }

    @Override
    public void insert(int index, E element) {
        int actualIndex = this.headIndex + index;
        this.indexValidation(actualIndex);

        if (actualIndex - this.headIndex < this.tailIndex - actualIndex) {
            this.insertAndShiftLeft(actualIndex - 1, element);
        } else {
            this.insertAndShiftRight(actualIndex, element);
        }
    }

    @Override
    public void set(int index, E element) {
        int actualIndex = this.headIndex + index;
        this.indexValidation(actualIndex);
        this.elements[actualIndex] = element;
    }

    @Override
    public E peek() {
        if (this.size != 0) {
            return this.getElementAt(this.headIndex);
        }
        return null;
    }

    @Override
    public E poll() {
        return this.removeFirst();
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public E get(int index) {
        int actualIndex = this.headIndex + index;
        this.indexValidation(actualIndex);
        return this.getElementAt(actualIndex);
    }

    @Override
    public E get(Object object) {
        if (isEmpty()) {
            return null;
        }

        for (int i = this.headIndex; i <= this.tailIndex; i++) {
            if (this.elements[i].equals(object)) {
                return this.getElementAt(i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        int actualIndex = this.headIndex + index;
        indexValidation(actualIndex);
        return this.getElementAt(actualIndex);
    }

    @Override
    public E remove(Object object) {
        if (isEmpty()) {
            return null;
        }

        for (int i = this.headIndex; i <= this.tailIndex; i++) {
            if (this.elements[i].equals(object)) {
                E element = this.getElementAt(i);
                this.elements[i] = null;

                for (int j = i; j < this.tailIndex; j++) {
                    this.elements[j] = this.elements[j + 1];
                }

                this.removeLast();
                return element;
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            E element = this.getElementAt(this.headIndex);
            this.elements[this.headIndex] = null;
            this.headIndex++;
            this.size--;
            return element;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (!isEmpty()) {
            E element = this.getElementAt(this.tailIndex);
            this.elements[this.tailIndex--] = null;
            this.size--;
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] newElements = new Object[this.size];
        int index = 0;
        for (int i = this.headIndex; i <= this.tailIndex; i++) {
            newElements[index++] = this.elements[i];
        }
        this.elements = newElements;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = headIndex;

            @Override
            public boolean hasNext() {
                return index <= tailIndex;
            }

            @Override
            public E next() {
                return getElementAt(index++);
            }
        };
    }

    private void insertAndShiftRight(int index, E element) {
        E lastElement = this.getElementAt(this.tailIndex);
        for (int i = this.tailIndex; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        this.addLast(lastElement);
    }

    private void insertAndShiftLeft(int index, E element) {
        E firstElement = this.getElementAt(this.headIndex);
        for (int i = this.headIndex; i < index; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[index] = element;
        this.addFirst(firstElement);
    }

    private void indexValidation(int index) {
        if (index < this.headIndex || index > this.tailIndex) {
            throw new IndexOutOfBoundsException("Index out of bound for index " + (index - this.headIndex));
        }
    }

    @SuppressWarnings("unchecked")
    private E getElementAt(int index) {
        return (E) this.elements[index];
    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2 + 1;

        Object[] updElements = new Object[newCapacity];

        int middle = newCapacity / 2;
        int begin = middle - this.size / 2;

        int startIndex = this.headIndex;
        for (int i = begin; i < begin + this.size; i++) {
            updElements[i] = this.elements[startIndex++];
        }

        this.headIndex = begin;
        this.tailIndex = this.headIndex + this.size - 1;

        return updElements;
    }
}

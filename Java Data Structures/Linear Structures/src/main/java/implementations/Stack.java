package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {

    private Node<E> top;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        Node(E element) {
            this.value = element;
            this.next = null;
        }
    }

    public Stack() {
        this.top = null;
        this.size = 0;
    }


    @Override
    public void push(E element) {
        Node<E> toInsert = new Node<>(element);
        toInsert.next = this.top;
        this.top = toInsert;
        this.size++;
    }

    @Override
    public E pop() {
        validateStackSize();
        Node<E> toRemove = this.top;
        this.top = toRemove.next;
        this.size--;
        return toRemove.value;
    }

    @Override
    public E peek() {
        validateStackSize();
        return this.top.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> checkElement = top;

            @Override
            public boolean hasNext() {
                return checkElement.next != null;
            }

            @Override
            public E next() {
                E testValue = this.checkElement.value;
                this.checkElement = this.checkElement.next;
                return testValue;
            }
        };
    }

    private void validateStackSize() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cannot iterate with an empty stack");
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> currentElement = this.top;
        while (currentElement != null) {
            E checkElement = currentElement.value;
            if (checkElement.equals(element)) {
                return true;
            }
            currentElement = currentElement.next;
        }
        return false;
    }
}

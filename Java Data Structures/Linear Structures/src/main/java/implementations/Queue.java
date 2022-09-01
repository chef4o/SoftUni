package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public static class Node<E> {
        private E value;
        private Node<E> next;

        Node (E element) {
            this.value = element;
            this.next = null;
        }
    }

    public Queue () {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void offer(E element) {
        if (this.isEmpty()) {
            this.head = this.tail = new Node<>(element);
        } else {
            Node<E> tempElement = new Node<>(element);
            this.tail.next = tempElement;
            this.tail = tempElement;
        }
        this.size++;
    }

    @Override
    public E poll() {
        checkIfEmpty();
        E toRemove = this.head.value;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
        }
        this.size--;
        return toRemove;
    }

    @Override
    public E peek() {
        checkIfEmpty();
        return this.head.value;
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

            private Node<E> tmpElement = head;

            @Override
            public boolean hasNext() {
                return this.tmpElement != null;
            }

            @Override
            public E next() {
                E nextTemp = this.tmpElement.value;
                tmpElement = tmpElement.next;
                return nextTemp;
            }
        };
    }

    public void checkIfEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("You cannot perform this action on an empty Queue");
        }
    }
}

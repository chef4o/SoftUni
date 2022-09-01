package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E element) {
            this.value = element;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> currentElement = new Node<>(element);
        currentElement.next = this.head;
        this.head = currentElement;
        size++;
    }

    @Override
    public void addLast(E element) {
        if (isEmpty()) {
            this.head = new Node<>(element);
        } else {
            Node<E> temp = this.head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node<>(element);
        }
        size++;
    }

    @Override
    public E removeFirst() {
        validateNonEmpty();

        E elementToRemove = this.head.value;
        this.head = this.head.next;
        this.size--;

        return elementToRemove;
    }

    @Override
    public E removeLast() {
        validateNonEmpty();

        if (this.size == 1) {
            E tempElement = this.head.value;
            this.head = null;

            return tempElement;
        }

        Node<E> tempLastElement = this.head;
        Node<E> elementToRemove = this.head.next;

        while (elementToRemove.next != null) {
            tempLastElement = elementToRemove;
            elementToRemove = elementToRemove.next;
        }

        tempLastElement.next = null;
        this.size--;

        return elementToRemove.value;
    }

    @Override
    public E getFirst() {
        validateNonEmpty();

        return this.head.value;
    }

    @Override
    public E getLast() {
        validateNonEmpty();

        Node<E> temp = this.head;

        while (temp.next != null) {
            temp = temp.next;
        }

        return temp.value;
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
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    private void validateNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot iterate with an empty stack");
        }
    }

}

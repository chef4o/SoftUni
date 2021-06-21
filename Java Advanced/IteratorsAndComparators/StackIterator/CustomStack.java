package IteratorsAndComparators.StackIterator;

import java.util.Iterator;

public class CustomStack implements Iterable<Integer>{
    private Node top;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node currentNode = top;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Integer next() {
                int element = currentNode.element;
                currentNode = currentNode.previous;
                return element;
            }
        };
    }

    private class Node{
        private int element;
        private Node previous;

        public Node(int element) {
            this.element = element;
        }
    }

    public void push(int number) {
        Node newNode = new Node(number);
        if (this.top != null) {
            newNode.previous = this.top;
        }
        this.top = newNode;
    }

    public int pop() {
        if (this.top == null) {
            throw new IllegalStateException("No elements");
        } else {
            int elementToPop = this.top.element;
            this.top = this.top.previous;
            return elementToPop;
        }
    }


}

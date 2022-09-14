package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {

    private List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.size() - 1);
    }

    private void heapifyUp(int index) {

        while (hasParent(index) && !isLess(index, getParent(index))) {
            Collections.swap(this.elements, index, getParent(index));
            index = getParent(index);
        }

    }

    private boolean isLess(int childIndex, int parentIndex) {
        return getAt(childIndex).compareTo(getAt(parentIndex)) <= 0;
    }

    private E getAt(int index) {
        return this.elements.get(index);
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private boolean hasParent(int index) {
        return index > 0;
    }

    @Override
    public E peek() {
        this.validateStructure();
        return getAt(0);
    }

    @Override
    public E poll() {
        validateStructure();
        E polledElement = getAt(0);
        Collections.swap(this.elements, 0, this.size() - 1);
        this.elements.remove(this.size() - 1);
        heapifyDown(0);
        return polledElement;
    }

    private void validateStructure() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Heap is empty upon peek attempt");
        }
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private void heapifyDown(int index) {

        while (getLeftChildIndex(index) < this.size() && isLess(index, getLeftChildIndex(index))) {
            int child = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);

            if (rightIndex < this.size() && isLess(child, rightIndex)) {
                child = rightIndex;
            }
            Collections.swap(this.elements, child, index);
            index = child;
        }

    }
}

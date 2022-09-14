package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private List<E> elements;

    public MaxHeap() {
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

        while (hasParent(index) && isLess(index, getParent(index))) {
            Collections.swap(this.elements, index, getParent(index));
            index = getParent(index);
        }

    }

    private boolean isLess(int childIndex, int parentIndex) {
        return getAt(childIndex).compareTo(getAt(parentIndex)) > 0;
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

    private void validateStructure() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Heap is empty upon peek attempt");
        }
    }
}

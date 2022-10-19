package main;

import java.util.*;
import java.util.stream.Collectors;

public class Hierarchy<T> implements IHierarchy<T> {

    private static final String ELEMENT_EXISTS = "Element already exists";
    private static final String ELEMENT_IS_ROOT = "Root element cannot be removed";

    private Map<T, HierarchyNode<T>> data;
    private HierarchyNode<T> root;

    public Hierarchy(T element) {
        this.data = new HashMap<>();
        HierarchyNode<T> root = new HierarchyNode<>(element);
        this.root = root;
        this.data.put(element, root);
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public void add(T element, T child) {
        HierarchyNode<T> parent = returnExisting(element);

        if (this.data.containsKey(child)) {
            throw new IllegalArgumentException(ELEMENT_EXISTS);
        }

        HierarchyNode<T> current = new HierarchyNode<>(child);
        current.setParent(parent);
        parent.getChildren().add(current);

        this.data.put(child, current);
    }

    @Override
    public void remove(T element) {
        HierarchyNode<T> toRemove = returnExisting(element);

        HierarchyNode<T> parent = toRemove.getParent();
        if (parent == null) {
            throw new IllegalStateException(ELEMENT_IS_ROOT);
        }

        List<HierarchyNode<T>> tempChildren = toRemove.getChildren();
        tempChildren.forEach(c -> c.setParent(parent));

        parent.getChildren().addAll(tempChildren);
        parent.getChildren().remove(toRemove);

        this.data.remove(toRemove.getValue());
    }

    @Override
    public Iterable<T> getChildren(T element) {

        HierarchyNode<T> current = returnExisting(element);

        return current.getChildren()
                .stream()
                .map(HierarchyNode::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public T getParent(T element) {
        HierarchyNode<T> current = returnExisting(element);
        return current.getParent() == null ? null : current.getParent().getValue();
    }

    @Override
    public boolean contains(T element) {
        return this.data.containsKey(element);
    }

    @Override
    public Iterable<T> getCommonElements(IHierarchy<T> other) {
        return this.data.keySet()
                .stream()
                .filter(other::contains)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Deque<HierarchyNode<T>> deque = new ArrayDeque<>(
                    List.of(root)
            );

            @Override
            public boolean hasNext() {
                return deque.size() > 0;
            }

            @Override
            public T next() {
                HierarchyNode<T> nextElement = deque.poll();
                deque.addAll(nextElement.getChildren());

                return nextElement.getValue();
            }
        };
    }

    private HierarchyNode<T> returnExisting(T element) {
        if (this.data.get(element) == null) {
            throw new IllegalArgumentException(ELEMENT_EXISTS);
        }
        return this.data.get(element);
    }

}

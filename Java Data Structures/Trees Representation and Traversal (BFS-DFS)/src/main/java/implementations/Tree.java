package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {

    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... children) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();

        for (Tree<E> child : children) {
            this.children.add(child);
            child.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        if (this.value == null) {
            return result;
        }

        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();
        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();
            result.add(current.value);
            current.children.forEach(childrenQueue::offer);
        }

        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();
        if (this.value == null) {
            return result;
        }

        this.dfs(this, result);

        return result;
    }

    private void dfs(Tree<E> node, List<E> result) {

        for (Tree<E> child : node.children) {
            this.dfs(child, result);
        }

        result.add(node.value);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> searchResult = find(parentKey);

        if (searchResult == null) {
            throw new IllegalArgumentException();
        }

        searchResult.children.add(child);
        child.parent = searchResult;
    }

    private Tree<E> find(E parentKey) {
        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();
        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();
            if (current.value.equals(parentKey)) {
                return current;
            }
            current.children.forEach(childrenQueue::offer);
        }

        return null;
    }

    @Override
    public void removeNode(E nodeKey) {

        Tree<E> toRemove = find(nodeKey);

        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        for (Tree<E> child : toRemove.children) {
            child.parent = null;
        }
        toRemove.children.clear();

        Tree<E> parent = toRemove.parent;
        if (parent != null) {
            parent.children.remove(toRemove);
        }

        toRemove.value = null;
    }

    @Override
    public void swap(E firstKey, E secondKey) {
        Tree<E> firstNode = find(firstKey);
        Tree<E> secondNode = find(secondKey);

        if (firstNode == null || secondNode == null) {
            throw new IllegalArgumentException();
        }

        Tree<E> firstParent = firstNode.parent;
        Tree<E> secondParent = secondNode.parent;

        if (firstParent == null) {
            swapRoot(secondNode);
            return;
        } else if (secondParent == null) {
            swapRoot(firstNode);
            return;
        }

        firstNode.parent = secondParent;
        secondNode.parent = firstParent;

        int firstNodeIndex = firstParent.children.indexOf(firstNode);
        int secondNodeIndex = secondParent.children.indexOf(secondNode);

        firstParent.children.set(firstNodeIndex, secondNode);
        secondParent.children.set(secondNodeIndex, firstNode);
    }

    private void swapRoot(Tree<E> node) {
        this.value = node.value;
        this.children = node.children;
        this.parent = null;
        node.parent = null;
    }
}




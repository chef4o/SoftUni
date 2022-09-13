package implementations;

import interfaces.AbstractTree;

import java.util.*;
import java.util.stream.Collectors;

public class Tree<E> implements AbstractTree<E> {

    E key;
    Tree<E> head;
    List<Tree<E>> children;

    public Tree(E element) {
        this.key = element;
        this.children = new ArrayList<>();
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.head = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.head;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        StringBuilder output = new StringBuilder();
        traverseWithPadding(output, 0, this);

        return output.toString().trim();
    }

    @Override
    public List<E> getLeafKeys() {
        return traverseWithBfs()
                .stream()
                .filter(Tree::isLeaf)
                .map(Tree::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<E> getMiddleKeys() {
        List<Tree<E>> allNodes = new ArrayList<>();
        this.traverseWithDfs(allNodes, this);

        return allNodes
                .stream()
                .filter(Tree::isMiddle)
                .map(Tree::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        List<Tree<E>> trees = traverseWithBfs();
        Tree<E> longestLeftMostTree = null;
        int longestPath = 0;

        for (Tree<E> tree : trees) {
            if (tree.isLeaf()) {
                int pathSize = getPathToHeadSize(tree);
                if (pathSize > longestPath) {
                    longestPath = pathSize;
                    longestLeftMostTree = tree;
                }
            }
        }
        return longestLeftMostTree;
    }

    @Override
    public List<E> getLongestPath() {
        List<Tree<E>> trees = traverseWithBfs();
        List<Tree<E>> treeElements = new ArrayList<>();
        int longestPath = 0;

        for (Tree<E> tree : trees) {
            if (tree.isLeaf()) {
                int pathSize = getPathToHeadSize(tree);
                if (pathSize > longestPath) {
                    longestPath = pathSize;
                    treeElements = getNodesToHead(tree);
                }
            }
        }

        List<E> result = treeElements
                .stream()
                .map(Tree::getKey)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        List<Tree<E>> allNodes = new ArrayList<>();
        this.traverseWithDfs(allNodes, this);

        List<List<E>> output = new ArrayList<>();

        for (Tree<E> tree : allNodes) {
            if (tree.isLeaf()) {
                List<Tree<E>> treeElements = getNodesToHead(tree);
                int elementsSum = treeElements
                        .stream()
                        .mapToInt(e -> (int)e.key)
                        .sum();
                if (elementsSum == sum) {
                    List<E> result = treeElements
                            .stream()
                            .map(Tree::getKey)
                            .collect(Collectors.toList());
                    output.add(result);
                }
            }
        }

        return output;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        List<Tree<E>> allNodes = new ArrayList<>(this.children);
        List<Tree<E>> results = new ArrayList<>();

        for (Tree<E> tree : allNodes) {
            int keysSum = sumTreeKeys(getKeyValues(tree));
            if (keysSum == sum) {
                results.add(tree);
            }
        }

        return results;
    }

    private int getPathToHeadSize(Tree<E> tree) {
        return getNodesToHead(tree).size();
    }

    private int sumTreeKeys(List<E> tree) {
        return tree.stream().mapToInt(e -> (int) e).sum();
    }

    private List<E> getKeyValues(Tree<E> tree) {
        List<Tree<E>> treeNodes = new ArrayList<>();
        this.traverseWithDfs(treeNodes, tree);

        return treeNodes
                .stream()
                .map(Tree::getKey)
                .collect(Collectors.toList());
    }

    private List<Tree<E>> getNodesToHead(Tree<E> tree) {
        List<Tree<E>> allNodes = new ArrayList<>();
        Tree<E> current = tree;
        while (current != null) {
            allNodes.add(current);
            current = current.head;
        }
        Collections.reverse(allNodes);
        return allNodes;
    }

    private boolean isLeaf() {
        return this.head != null && this.children.isEmpty();
    }

    private boolean isMiddle() {
        return this.head != null && !this.children.isEmpty();
    }

    private List<Tree<E>> traverseWithBfs() {
        Deque<Tree<E>> deque = new ArrayDeque<>();
        List<Tree<E>> allNodes = new ArrayList<>();
        deque.offer(this);

        while (!deque.isEmpty()) {
            Tree<E> tree = deque.poll();
            allNodes.add(tree);

            for (Tree<E> child : tree.children) {
                deque.offer(child);
            }
        }

        return allNodes;
    }

    private void traverseWithDfs(List<Tree<E>> collection, Tree<E> tree) {
        collection.add(tree);
        for (Tree<E> child : tree.children) {
            child.traverseWithDfs(collection, child);
        }
    }

    private void traverseWithPadding(StringBuilder output, int indent, Tree<E> eTree) {
        output.append(this.getPadding(indent))
                .append(eTree.getKey())
                .append(System.lineSeparator());

        for (Tree<E> child : eTree.children) {
            traverseWithPadding(output, indent + 2, child);
        }
    }

    private String getPadding(int size) {
        return " ".repeat(Math.max(0, size));
    }
}




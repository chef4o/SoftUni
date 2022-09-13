package implementations;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TreeFactory {
    private Map<Integer, Tree<Integer>> nodesByKeys;

    public TreeFactory() {
        this.nodesByKeys = new LinkedHashMap<>();
    }

    public Tree<Integer> createTreeFromStrings(String[] input) {
        Arrays.stream(input)
                .forEach(e -> {
                    int[] elements = Arrays.stream(e.split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();

                    this.addEdge(elements[0], elements[1]);
                });
        return this.getRoot();
    }

    private Tree<Integer> getRoot() {
        for (Tree<Integer> element : this.nodesByKeys.values()) {
            if (element.getParent() == null) {
                return element;
            }
        }
        return null;
    }

    public Tree<Integer> createNodeByKey(int key) {
        this.nodesByKeys.putIfAbsent(key, new Tree<>(key));
        return this.nodesByKeys.get(key);
    }

    public void addEdge(int parent, int child) {
        Tree<Integer> parentTree = this.createNodeByKey(parent);
        Tree<Integer> childTree = this.createNodeByKey(child);

        childTree.setParent(parentTree);
        parentTree.addChild(childTree);
    }
}




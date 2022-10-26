import java.util.function.Consumer;

class AATree<T extends Comparable<T>> {
    private Node<T> root;

    private static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;
        public int level;

        public Node(T value) {
            this.value = value;
            this.level = 1;
        }
    }

    public AATree() {
    }

    public boolean isEmpty() {
        return this.root == null;

    }

    public void clear() {
        this.root = null;
    }

    public void insert(T element) {
        this.root = this.insert(this.root, element);
    }

    private Node<T> insert(Node<T> node, T element) {
        if (node == null) {
            return new Node<>(element);
        }

        if (element.compareTo(node.value) < 0) {
            node.left = this.insert(node.left, element);
        } else if (element.compareTo(node.value) > 0) {
            node.right = insert(node.right, element);
        }

        node = balance(node);

        return node;
    }

    private Node<T> balance(Node<T> node) {
        node = skew(node);
        node = split(node);
        return node;
    }

    private Node<T> split(Node<T> node) {
        if (needsSplit(node)) {
            node = rotateLeft(node);
            node.level++;

            return node;
        }

        return node;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> result = node.right;
        node.right = result.left;
        result.left = node;

        return result;
    }

    private Node<T> skew(Node<T> node) {
        if (needsSkew(node)) {
            return rotateRight(node);
        }

        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> result = node.left;
        node.left = result.right;
        result.right = node;

        return result;
    }

    public int countNodes() {
        return this.countChildren(this.root);
    }

    private int countChildren(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return this.countChildren(node.left)
                + this.countChildren(node.right) + 1;
    }

    public boolean search(T element) {
        return search(this.root, element);
    }

    private boolean search(Node<T> node, T element) {
        if (node == null) {
            return false;
        }

        if (element.compareTo(node.value) < 0) {
            return search(node.left, element);
        } else if (element.compareTo(node.value) > 0) {
            return search(node.right, element);
        }

        return true;
    }

    public void inOrder(Consumer<T> consumer) {
        consumeInOrder(this.root, consumer);
    }

    private void consumeInOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        consumeInOrder(node.left, consumer);
        consumer.accept(node.value);
        consumeInOrder(node.right, consumer);
    }

    public void preOrder(Consumer<T> consumer) {
        consumePreOrder(this.root, consumer);
    }

    private void consumePreOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.value);
        consumePreOrder(node.left, consumer);
        consumePreOrder(node.right, consumer);
    }

    public void postOrder(Consumer<T> consumer) {
        consumePostOrder(this.root, consumer);
    }

    private void consumePostOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        consumePostOrder(node.left, consumer);
        consumePostOrder(node.right, consumer);
        consumer.accept(node.value);
    }

    private boolean needsSkew(Node<T> node) {
        return node.left != null
            && node.left.level == node.level;
    }

    private boolean needsSplit(Node<T> node) {
        return node.right != null
            && node.right.right != null
            && node.right.level == node.level
            && node.right.right.level == node.level;
    }
}
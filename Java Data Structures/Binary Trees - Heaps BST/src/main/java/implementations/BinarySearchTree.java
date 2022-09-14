package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {

    private Node<E> root;
    private Node<E> leftChild;
    private Node<E> rightChild;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node<E> node) {
        this.clone(node);
    }

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.getRoot() == null) {
            this.root = newNode;
        } else {
            Node<E> current = this.root;
            Node<E> previous = current;

            while (current != null) {
                previous = current;

                if (isLess(element, current.value)) {
                    current = current.leftChild;
                } else if (isGreater(element, current.value)) {
                    current = current.rightChild;
                } else {
                    return;
                }
            }

            if (isLess(element, previous.value)) {
                previous.leftChild = newNode;
            } else if (isGreater(element, previous.value)) {
                previous.rightChild = newNode;
            }
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> temp = this.root;

        while (temp != null)  {
            if (isLess(element, temp.value)) {
                temp = temp.leftChild;
            } else if (isGreater(element, temp.value)) {
                temp = temp.rightChild;
            } else {
                return true;
            }
        }

        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        AbstractBinarySearchTree<E> result = new BinarySearchTree<>();

        Node<E> temp = this.root;

        while (temp != null) {
            if (isLess(element, temp.value)) {
                temp = temp.leftChild;
            } else if (isGreater(element, temp.value)) {
                temp = temp.rightChild;
            } else {
                return new BinarySearchTree<>(temp);
            }
        }
        return result;
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.rightChild;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }

    private void clone(Node<E> node) {
        if (node != null) {
            this.insert(node.value);
            this.clone(node.leftChild);
            this.clone(node.rightChild);
        }
    }

    private boolean isLess(E first, E second) {
        return first.compareTo(second) < 0;
    }

    private boolean isGreater(E first, E second) {
        return first.compareTo(second) > 0;
    }
}

package inheritance.inheritedStack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackOfStrings {

    private ArrayList<String> data;
    private int lastElementIndex;

    public StackOfStrings() {
        this.data = new ArrayList<>();
        lastElementIndex = -1;
    }

    public void push (String element) {
        data.add(element);
        lastElementIndex++;
    }

    public String pop() {
        checkIfEmpty();
        return data.remove(lastElementIndex--);
    }

    public String peek() {
        checkIfEmpty();
        return data.get(lastElementIndex);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void checkIfEmpty() {
        if (lastElementIndex < 0) {
            throw new NoSuchElementException("No such element");
        }
    }
}

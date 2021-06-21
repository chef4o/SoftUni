package IteratorsAndComparators.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>  {
    int index;
    List<String> data;

    public ListyIterator(List<String> data) {
        this.data = data;
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public boolean move() {
        if (iterator().hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void print(){
        validatePrint();
        System.out.println(this.data.get(this.index));
    }

    public void printAll(){
        validatePrint();
        this.data.forEach(e -> System.out.printf("%s ", e));
    }

    private void validatePrint() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return  index < data.size() - 1;
            }

            @Override
            public String next() {
                String next = data.get(index);
                index++;
                return next;
            }
        };
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AATree<Integer> tree = new AATree<>();

        tree.insert(5);
        tree.insert(7);
        tree.insert(2);
        tree.insert(1);

        List<Integer> actual = new ArrayList<>();
        tree.preOrder(actual::add);

        System.out.println(actual);
    }
}

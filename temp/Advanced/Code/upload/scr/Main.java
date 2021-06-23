public class Main {
    public static void main(String[] args) {

        Integer[] intArr = ArrayCreator.create(13, 13);
        String[] strArr = ArrayCreator.create(String.class, 13, "Test");

        for (String s : strArr) {
            print(s);
        }

    }

    public static <T> void print(T obj) {
        System.out.println(obj);
    }
}
package implementations;

import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.add(11);
        deque.add(12);
        deque.add(13);
        deque.add(14);
        deque.add(15);
        deque.add(16);

//        void add(E element);
//        void offer(E element);
//        void addFirst(E element);
//        void addLast(E element);
//        void push(E element);
//        void insert(int index, E element);
//        void set(int index, E element);
//        E peek();
//        E poll();
//        E pop();
//        E get(int index);
//        E get(Object object);
//        E remove(int index);
//        E remove(Object object);
//        E removeFirst();
//        E removeLast();
//        int size();
//        int capacity();
//        void trimToSize();
//        boolean isEmpty();

        for (Integer integer : deque) {
            System.out.println(integer);
        }
    }

}
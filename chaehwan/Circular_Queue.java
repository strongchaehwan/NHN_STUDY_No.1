import java.util.Iterator;
import java.util.Arrays;

interface List<E> extends Iterable<E> {
    void enqueue(E value);

    E dequeue();

    boolean isFull();

    boolean isEmpty();

    E peek();// 가장 먼저 들어와 있는 데이터

    int size();
}

public class Circular_Queue<E> implements List<E> {
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private E[] elements;

    public Circular_Queue(int n) {
        this.elements = (E[]) new Object[n];
    }

    @Override
    public Iterator<E> iterator() {
        return Arrays.stream(elements).iterator();
    }

    @Override
    public void enqueue(E value) {
        if (isFull()) {
            throw new IllegalArgumentException("큐가 가득 찼습니다");
        }
        this.elements[rear++] = value;
        this.rear = this.rear % this.elements.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("큐가 비어 있습니다.");
        }
        E e = elements[front];
        elements[front++] = null;
        this.front = front % elements.length;
        size--;
        return e;
    }

    @Override
    public boolean isFull() {
        return front == rear && elements[front] != null;
    }

    @Override
    public boolean isEmpty() {
        return front == rear && elements[front] == null;
    }

    @Override
    public E peek() {
        E e = elements[front];
        return e;
    }

    @Override
    public int size() {
        return this.size;
    }

}

class Circular_Queue_Main {
    public static void main(String[] args) {
        Circular_Queue<Integer> queue = new Circular_Queue<>(5);
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            // queue.enqueue(5);
            System.out.println(queue.dequeue());
            System.out.println(queue.peek());
            System.out.println(queue.peek());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

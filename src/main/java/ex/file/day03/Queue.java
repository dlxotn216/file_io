package ex.file.day03;

public interface Queue {

    void enqueue(int obj);

    int dequeue();

    int peek();

    boolean isEmpty();

    boolean isFull();

    void print();
}

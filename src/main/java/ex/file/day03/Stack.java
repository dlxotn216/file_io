package ex.file.day03;

public interface Stack<T> {
    void push(T obj);

    T pop();

    boolean isFull();

    boolean isEmpty();
}

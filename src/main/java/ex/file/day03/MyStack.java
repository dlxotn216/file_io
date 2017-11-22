package ex.file.day03;

public class MyStack<T> implements Stack<T> {
    private final static int max = 10;
    private int top = -1;
    private T[] stack = (T[])new Object[max];

    @Override
    public void push(T obj) {
        if (isFull()) {
            return;
        }
        stack[++top] = obj;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stack[top--];
    }

    @Override
    public boolean isFull() {
        return top == (max - 1);
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}

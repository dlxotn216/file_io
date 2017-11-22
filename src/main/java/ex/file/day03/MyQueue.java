package ex.file.day03;

public class MyQueue implements Queue {
    private final static int max = 4;       //하나의 빈 공강 낭비 필요
    private int[] queue = new int[max];
    private int rear = 0;
    private int front = 0;

    @Override
    public void enqueue(int obj) {
        if (isFull()) {
            System.out.println("queue is fulled");
            return;
        }
        queue[rear] = obj;
        rear = getPosition(rear+1);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            throw new ArrayIndexOutOfBoundsException();
        }
        int target = queue[front];
        front = getPosition(front+1);
        return target;
    }

    @Override
    public int peek() {
        return queue[rear];
    }

    @Override
    public boolean isEmpty() {
        return getPosition(rear) == getPosition(front);
    }

    @Override
    public boolean isFull() {
        return getPosition(rear+1) == getPosition(front);
    }

    @Override
    public void print(){
        for(int i : queue){
            System.out.println(i);
        }
    }

    private int getPosition(int current) {
        return current % max;
    }

    public static void main(String[] args) {
        Queue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.print();

        System.out.printf(queue.dequeue()+" ");
        System.out.printf(queue.dequeue()+" ");
        System.out.printf(queue.dequeue()+" ");

    }
}

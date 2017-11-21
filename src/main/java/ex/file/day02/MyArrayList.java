package ex.file.day02;

public class MyArrayList<T> implements List<T> {
    private static final int initMaxLength = 10;
    private static int currentMaxLength = initMaxLength;

    private int pos = 0;
    private T[] arr = (T[]) new Object[initMaxLength];

    public MyArrayList() {

    }

    @Override
    public void add(T obj) {
        arr[pos++] = obj;
        if (pos == currentMaxLength) {
            System.out.println("Log -> array 용량 증가");
            T[] temp = arr.clone();
            currentMaxLength += initMaxLength;
            arr = (T[]) new Object[currentMaxLength];

            for (int i = 0; i < temp.length; i++) {
                arr[i] = temp[i];
            }
        }
    }

    @Override
    public void remove(T target) {
        int targetPos = -1;
        for (int i = 0; i < arr.length; i++) {
            if (target.equals(arr[i])) {
                targetPos = i;
            }
        }

        if (targetPos == -1) {
            return;
        }
        System.out.println("remove [" + targetPos + "]");
        for (int i = targetPos; i < pos - 1; i++) {
            arr[i] = arr[i + 1];
        }
        pos--;
    }

    @Override
    public int size() {
        return pos;
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            return null;
        }

        if (index > pos) {
            return null;
        }

        return arr[index];
    }

    @Override
    public void set(int index, T target) {
        if (index < 0) {
            return;
        }

        if (index > pos) {
            return;
        }

        arr[index] = target;
    }

    @Override
    public boolean contains(T target) {
        if (pos < 0) {
            return false;
        }

        for (int i = 0; i < pos; i++) {
            if (arr[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void print() {
        for (int i = 0; i < pos; i++) {
            System.out.println("[" + i + "]" + arr[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        List<String> list = new MyArrayList<>();
        System.out.println("empty: " + list.isEmpty());

        list.add("aegw");
        list.add("test");
        list.add("awg");
        list.add("test");
        list.add("ewag");
        list.add("weg");
        list.add("aweg");
        list.add("123");
        list.add("aewgaewg");
        list.add("awegawg");
        list.add("aewgaw");
        list.add("35");
        list.add("awegawg");
        list.add("awegawgawg");
        list.add("aewgawgaweg");
        list.print();

        System.out.println("contain test : " + list.contains("test"));
        list.set(0, "abc");

        System.out.println("set [0] to abc");
        list.print();

        list.remove("123");
        System.out.println("after remove 123");
        list.print();

        list.add("akkk test");
        list.add("62362");
        list.print();
    }
}

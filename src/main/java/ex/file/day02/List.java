package ex.file.day02;

public interface List<T> {
    void add(T obj);

    void remove(T target);

    int size();

    T get(int index);

    void set(int index, T target);

    boolean contains(T target);

    boolean isEmpty();

    void print();
}

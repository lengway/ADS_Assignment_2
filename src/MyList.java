public interface MyList<T> {
    void add(T element);
    void set(int index, T item);
    void add(int index, T item);
    void addFirst(T element);
    void addLast(T element);
    void remove(int index);
    void removeFirst();
    void removeLast();
    T get(int index);
    T getFirst();
    T getLast();
    void sort();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    public Object[] toArray();
    void clear();
    int size();
}

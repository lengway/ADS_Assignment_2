public class MyMinHeap<T extends Comparable<T>> {
    private T[] elements;
    private int size;

    public MyMinHeap() {
        elements = (T[]) new Comparable[10];
        size = 0;
    }

    private void resize() {
        T[] newElements = (T[]) new Comparable[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && elements[index].compareTo(elements[parent]) < 0) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < size && elements[left].compareTo(elements[smallest]) < 0) {
            smallest = left;
        }

        if (right < size && elements[right].compareTo(elements[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public void insert(T item) {
        if (size == elements.length) {
            resize();
        }
        elements[size] = item;
        heapifyUp(size);
        size++;
    }

    public T poll() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        T min = elements[0];
        elements[0] = elements[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return elements[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        elements = (T[]) new Comparable[10];
        size = 0;
    }

    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        T[] array = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }
}
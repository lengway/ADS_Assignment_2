public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int length;

    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    public void add(T element) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = element;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }

        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        if (length == elements.length) {
            increaseCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, length - index);
        elements[index] = item;
        length++;
    }

    @Override
    public void addFirst(T element) {
        if (length == elements.length) {
            increaseCapacity();
        }
        System.arraycopy(elements, 0, elements, 1, length);
        elements[0] = element;
        length++;
    }


    @Override
    public void addLast(T element) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = element;
    }

    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i]; //upcasting
        }
        elements = newElements;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index]; //downcasting
    }

    @Override
    public T getFirst() {
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        return (T) elements[length - 1];
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) elements[j];
                T b = (T) elements[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i] == object) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int lastIndex = -1;
        for (int i = 0; i < length; i++) {
            if (elements[i] == object) {
                lastIndex = i;
            }

        }
        return lastIndex;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i] == object) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        for (int i = 0; i < length; i++) {
            result[i] = elements[i];
        }
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            elements[i] = null;
        }
        length = 0;
    }

    @Override
    public void remove(int index){
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i+1];
        }
        elements[--length] = null;
    }


    @Override
    public void removeFirst() {
        if (length == 0) throw new IllegalStateException("List is empty");
        remove(0);
    }


    @Override
    public void removeLast() {
        elements[length - 1] = null;
        length--;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    public int size() {
        return length;
    }
}
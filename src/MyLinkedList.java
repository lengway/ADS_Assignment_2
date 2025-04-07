public class MyLinkedList<T> implements MyList<T>{
    private MyNode<T> node;
    private int length;

    public MyLinkedList(){
        node = null;
        length = 0;
    }

    @Override
    public void add(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if (node == null) {
            node = newNode;
        } else {
            MyNode<T> current = node;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> current = node;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = element;
    }


    @Override
    public void add(int index, T element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> newNode = new MyNode<>(element);

        if (index == 0) {
            addFirst(element);
        } else {
            MyNode<T> current = node;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        length++;
    }

    @Override
    public void addFirst(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        newNode.next = node;
        node = newNode;
        length++;
    }

    @Override
    public void addLast(T element) {
        add(length, element);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            removeFirst();
        } else {
            MyNode<T> current = node;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
        }

        length--;
    }

    @Override
    public void removeFirst() {
        node = node.next;
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > length){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = node;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return node.data;
    }

    @Override
    public T getLast() {
        if (node == null) {
            return null;
        }

        MyNode<T> current = node;
        while (current.next != null){
            current = current.next;
        }

        return current.data;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = node;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = node;
        int index = -1;
        int currentIndex = 0;

        while (current != null) {
            if (current.data.equals(object)) {
                index = currentIndex;
            }
            current = current.next;
            currentIndex++;
        }

        return index;
    }


    @Override
    public boolean exists(Object object) {
        MyNode<T> current = node;
        while (current != null) {
            if (current.data.equals(object)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        MyNode<T> current = node;

        Object[] result = new Object[length];
        for (int i = 0; i < length; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public void clear() {
        MyNode<T> current = node;
        while (current != null) {
            MyNode<T> nextNode = current.next;
            current.data = null;
            current.next = null;
            current = nextNode;
        }
        node = null;
        length = 0;
    }


    @Override
    public int size() {
        return length;
    }
}
import java.util.NoSuchElementException;

public class MyQueue<T>{
    private MyNode<T> front;
    private MyNode<T> rear;
    private int length;

    public MyQueue() {
        front = null;
        rear = null;
        length = 0;
    }

    public void enqueue(T element) {
        MyNode<T> newNode = new MyNode<>(element);

        if (front == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;

        length++;
    }

    public T dequeue() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        T element = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        length--;

        return element;
    }

    public T peek() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }

        return (T) front.data;
    }

    public T bottom() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }

        return (T) rear.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return length;
    }

    public boolean exists(T element) {
        MyNode<T> current = front;

        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public Object[] toArray() {
        Object[] array = new Object[length];
        MyNode<T> current = front;
        for (int i = 0; i < length; i++) {
            array[i] = current.data;
            current = current.next;
        }

        return array;
    }

    public void clear() {
        front = null;
        rear = null;
        length = 0;
    }
}
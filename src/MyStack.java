public class MyStack<T>{
    private MyNode<T> top;
    private int length;

    public MyStack() {
        top = null;
        length = 0;
    }

    public void push(T element) {
        MyNode<T> newNode = new MyNode<>(element);

        newNode.next = top;
        top = newNode;
        length++;
    }

    public T pop() {
        if (length == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        T temp = top.data;
        top = top.next;
        length--;
        return temp;
    }

    public T peek() {
        if (length == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        return top.data;
    }

    public void clear() {
        top = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }
}

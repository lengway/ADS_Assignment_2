public class Main {
    public static void main(String[] args) {
        System.out.println("===== Testing MyArrayList =====");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("ArrayList: " + arrayList.get(0) + ", " + arrayList.get(1) + ", " + arrayList.get(2));
        arrayList.remove(1);
        System.out.println("After remove(1): " + arrayList.get(0) + ", " + arrayList.get(1));
        System.out.println("Contains 30? " + arrayList.exists(30));
        System.out.println("Size: " + arrayList.size());

        System.out.println("\n===== Testing MyLinkedList =====");
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        System.out.println("LinkedList elements: ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        linkedList.remove(1);
        System.out.println("After remove(1): ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        System.out.println("\n===== Testing MyStack =====");
        MyStack<Double> stack = new MyStack<>();
        stack.push(1.1);
        stack.push(2.2);
        stack.push(3.3);
        System.out.println("Stack top: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Now top: " + stack.peek());
        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("\n===== Testing MyQueue =====");
        MyQueue<Character> queue = new MyQueue<>();
        queue.enqueue('A');
        queue.enqueue('B');
        queue.enqueue('C');
        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front after dequeue: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        System.out.println("\n===== Testing MyMinHeap =====");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
        System.out.println("Heap peek (min): " + heap.peek());
        System.out.println("Polling elements from heap:");
        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
        System.out.println("\nIs heap empty? " + heap.isEmpty());
    }
}

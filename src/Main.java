import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        print(list);
        System.out.println("--------------------");

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        print(list2);

    }

    public static void print(MyList<Integer> list) {
        int i = 0;
        while (i < list.size()) {
            System.out.print(list.get(i++) + " ");
        }

        System.out.println();
    }
}
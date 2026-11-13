package AV4;

import java.util.Scanner;

public class DLL_P_K {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();
        DLL<String> list = new DLL<>();

        for (int i = 0; i < n; i++) {
            String curr = scanner.next();
            list.insertLast(curr);
        }

        DLLNode<String> firstOdd = new DLLNode<>(null, null, null);

        DLLNode<String> current = list.getFirst();

        int counterFirst = 0;
        int couterLast = list.getSize() - 1;

        while (current != null) {
            if (current.element.length() == p) {
                firstOdd = current;
                break;
            }
            counterFirst++;
            current = current.succ;
        }

        DLLNode<String> lastEven = new DLLNode<>(null, null, null);
        current = list.getLast();

        while (current != null) {
            if (current.element.length() == k) {
                lastEven = current;
                break;
            }
            couterLast--;
            current = current.pred;
        }

        System.out.println(firstOdd.element + " " + counterFirst);
        System.out.println(lastEven.element + " " + couterLast);

        String tmp = firstOdd.element;
        firstOdd.element = lastEven.element;
        lastEven.element = tmp;

        System.out.println(list.toString());
    }

    public static DLLNode<String> getFirstOdd(DLL<String> list) {
        DLLNode<String> current = list.getFirst();
        while (current != null) {
            if (current.element.length() % 2 != 0) {
                return current;
            }
            current = current.succ;
        }

        return null;
    }

    public static DLLNode<String> getLastEven(DLL<String> list) {
        DLLNode<String> current = list.getLast();

        while (current != null) {
            if (current.element.length() % 2 == 0) {
                return current;
            }
            current = current.pred;
        }
        return null;
    }
}


package AV1.DLL;

import impl.DLL.DLL;
import impl.DLL.DLLNode;

public class Palindrome {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<>();

        list.insertLast(1);
        list.insertLast(2);
//        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(1);

        System.out.println("List: " + list);
        System.out.println("Is palindrome: " + isPalindrome(list));
    }

    public static <T> boolean isPalindrome(DLL<T> list) {
        DLLNode<T> first = list.getFirst();
        DLLNode<T> last = list.getLast();

        while (first != last && last.succ != first) {
            if (!first.element.equals(last.element)) {
                return false;
            }
            first = first.succ;
            last = last.pred;
        }

        return true;
    }
}

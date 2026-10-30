package AV1.SLL;

import impl.SLL.SLL;
import impl.SLL.SLLNode;

public class JoinSorted {
    public static void main(String[] args) {
        SLL<Integer> list1 = new SLL<>();
        list1.insertLast(1);
        list1.insertLast(3);
        list1.insertLast(5);

        SLL<Integer> list2 = new SLL<>();
        list2.insertLast(2);
        list2.insertLast(3);
        list2.insertLast(10);

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        JoinSorted joinSortedObj = new JoinSorted();
        SLL<Integer> result = joinSortedObj.joinSorted(list1, list2);
        System.out.println("Joined List: " + result);
    }


    public SLL<Integer> joinSorted(SLL<Integer> list1, SLL<Integer> list2) {
        SLL<Integer> result = new SLL<>();
        SLLNode<Integer> curr1 = list1.getFirst();
        SLLNode<Integer> curr2 = list2.getFirst();

        while (curr1 != null && curr2 != null){
            if (curr1.element < curr2.element){
                result.insertLast(curr1.element);
                curr1 = curr1.succ;
            } else if (curr2.element < curr1.element){
                result.insertLast(curr2.element);
                curr2 = curr2.succ;
            } else {
                result.insertLast(curr1.element);
                curr1 = curr1.succ;
            }
        }

        while (curr1 != null){
            result.insertLast(curr1.element);
            curr1 = curr1.succ;
        }

        while (curr2 != null){
            result.insertLast(curr2.element);
            curr2 = curr2.succ;
        }

        return result;
    }
}

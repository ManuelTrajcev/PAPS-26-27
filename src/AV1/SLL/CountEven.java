package AV1.SLL;

import impl.SLL.SLL;
import impl.SLL.SLLNode;

public class CountEven {
    public static void main(String[] args) {
        SLL<Integer> list = new SLL<>();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);

        CountEven ex2 = new CountEven();
        Integer numEven = ex2.NumEven(list);
        System.out.println("Number of even elements: " + numEven);
    }

    public Integer NumEven(SLL<Integer> list) {
        SLLNode<Integer> curr = list.getFirst();

        int count = 0;
        while (curr.succ != null) {
            if (curr.element % 2 == 0) {
                count++;
            }


            curr = curr.succ;
        }

        return count;
    }
}

package impl.array;

import java.util.ArrayList;

public class FindAndDelete<T> {
    public static void main(String[] args) {
        FindAndDelete<String> fnd = new FindAndDelete<>();

        Array<String> array1 = new Array<>(3);
        Array<String> array2 = new Array<>(3);

        array1.insertLast("a");
        array1.insertLast("b");
        array1.insertLast("c");

        array2.insertLast("d");
        array2.insertLast("b");
        array2.insertLast("e");

        System.out.println("Array 1 before deletion: " + array1);
        System.out.println("Array 2 before deletion: " + array2);

        fnd.FindDelete(array1, array2);

        System.out.println("Array 1 after deletion: " + array1);
        System.out.println("Array 2 after deletion: " + array2);
    }

    public void FindDelete(Array<T> array1, Array<T> array2){
        if (array1.getSize() == array2.getSize()) {
            for (int i=0; i < array1.getSize(); i++) {
                if (array1.get(i).equals(array2.get(i))){
                    array1.delete(i);
                    array2.delete(i);
                }
            }
        }

        return;
    }
}

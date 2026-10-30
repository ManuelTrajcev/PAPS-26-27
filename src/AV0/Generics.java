package AV0;

import java.util.ArrayList;
import java.util.List;


interface Interface1 {
    void method1();
    Integer method2();
}

class Box<K, V> implements Interface1 {
    private K key;
    private V value;

    public Box(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public void method1() {

    }

    @Override
    public Integer method2() {
        return 10;
    }
}

class Circle implements Interface1 {
    @Override
    public void method1() {

    }

    @Override
    public Integer method2() {
        return 20;
    }

}

public class Generics {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        Integer sum = 0;
        list1.add(1);
        list1.add(123);

        Circle circle1 = new Circle();
        Box<Integer, String> box1 = new Box<>(1, "One");


        System.out.println("Box 1 method2: " + box1.method2());
        System.out.println("Circle 1 method2: " + circle1.method2());

    }
}

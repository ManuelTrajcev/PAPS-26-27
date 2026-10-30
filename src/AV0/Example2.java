package AV0;


interface VendingMachine<T> {
    void insertItem(T item);
    T dispenseItem();
}
class CoffeeVendingMachine<T> implements VendingMachine<T> {
    T item;

    public CoffeeVendingMachine() {
        this.item = null;
    }

    @Override
    public void insertItem(T item) {
        this.item = item;
    }

    @Override
    public T dispenseItem() {
        return item;
    }
}

class TeaVendingMachine<T> implements VendingMachine<T> {
    Integer counter;
    T item;

    public TeaVendingMachine() {
        this.counter = 0;
        this.item = null;
    }

    @Override
    public void insertItem(T item) {
        this.item = item;
        this.counter++;
    }

    @Override
    public T dispenseItem() {
        return item;
    }
}

class Container<T> {
    private T object;

    Container(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

}

public class Example2 {
    public static void main(String[] args) {
        Container<String> stringContainer = new Container<>("Hello, World!");
        Container<Integer> integerContainer = new Container<>(42);

        CoffeeVendingMachine<String> coffeeMachine = new CoffeeVendingMachine<>();
        coffeeMachine.insertItem("Espresso");
        String dispensedItem = coffeeMachine.dispenseItem();
        System.out.println("Dispensed item: " + dispensedItem);

        TeaVendingMachine<Integer> teaMachine = new TeaVendingMachine<>();
        teaMachine.insertItem(5);
        Integer dispensedTea = teaMachine.dispenseItem();
        System.out.println(dispensedTea);

//        System.out.println("String value: " + stringContainer.getObject());
//        System.out.println("Integer value: " + integerContainer.getObject());
    }
}

package AV3.Greedy;

import java.util.ArrayList;
import java.util.List;

class Item {
    String name;
    double weight;
    double value;
    double coef;

    public Item(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.coef = value / weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", value=" + value +
                ", coef=" + coef +
                '}';
    }
}

public class Knapsack {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Cards", 0.5, 5));
        items.add(new Item("Book", 20, 150));
        items.add(new Item("Clothes", 10, 200));
        items.add(new Item("CdPlayer", 5, 80));

        double remainingWeight = 20;

        System.out.println("All items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
        System.out.println("--------------------------------");

        System.out.println("Selected items from Full Item Knapsack:");
        List<Item> selectedItems = fullItemsKnapsack(items, 20);
        for (int i = 0; i < selectedItems.size(); i++) {
            System.out.println(selectedItems.get(i));
        }

        System.out.println("--------------------------------");
        System.out.println("Selected items from Fractional Knapsack:");
        List<Item> fractionalSelectedItems = fractionalKnapsack(items, 20);
        for (int i = 0; i < fractionalSelectedItems.size(); i++) {
            System.out.println(fractionalSelectedItems.get(i));
        }
    }

    public static void sortItemsByCoef(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size() - 1; j++) {
                if (items.get(j).coef < items.get(j + 1).coef) {
                    Item temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
    }

    public static List<Item> fractionalKnapsack(List<Item> items, double capacity) {
        List<Item> selectedItems = new ArrayList<>();
        double remainingWeight = capacity;

        sortItemsByCoef(items);

        for (Item item : items) {
            if (remainingWeight - item.weight >= 0) {
                selectedItems.add(item);
                remainingWeight -= item.weight;
            } else if (remainingWeight > 0) {
                double fraction = remainingWeight / item.weight;
                double fractionalValue = item.value * fraction;
                Item fractionItem = new Item(item.name + " - fractional", remainingWeight, fractionalValue);
                selectedItems.add(fractionItem);
                remainingWeight = 0;
            }
        }
        return selectedItems;
    }

    public static List<Item> fullItemsKnapsack(List<Item> items, double capacity) {
        List<Item> selectedItems = new ArrayList<>();
        double remainingWeight = capacity;

        sortItemsByCoef(items);

        for (Item item : items) {
            if (remainingWeight - item.weight >= 0) {
                selectedItems.add(item);
                remainingWeight -= item.weight;
            }
        }
        return selectedItems;
    }
}

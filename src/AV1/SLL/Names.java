package AV1.SLL;

import impl.SLL.SLL;
import impl.SLL.SLLNode;

import java.util.Scanner;

public class Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        SLL<String> names = new SLL<>();

        line = scanner.nextLine();
        while (!line.equals("KRAJ")) {
            if (isValidName(line)) {
                names.insertFirst(line);
            }

            line = scanner.nextLine();
        }

        System.out.println(names);
    }

    public static boolean isValidName(String name) {
        return Character.isUpperCase(name.charAt(0));
    }
}

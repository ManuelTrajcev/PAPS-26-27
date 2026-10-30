package AV2.Stack;


import impl.Stack.LinkedStack;
import impl.Stack.Stack;

import java.util.Scanner;

public class ExpressionValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
//        4+12-(44-23)}
        Stack<Character> stack = new LinkedStack<>();
        Boolean isValid = true;

        for (int i = 0; i < expression.length(); i++) {
            Character closed = expression.charAt(i);
            if (closed == '(' || closed == '[' || closed == '{') {
                stack.push(closed);
            } else if (closed == ')' || closed == ']' || closed == '}') {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                Character opened = stack.peek();
                if (validateExpression(opened, closed)) {
                    stack.pop();
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            isValid = false;
        }

        System.out.println("Is Expresion valid: " + isValid);
    }

    public static boolean validateExpression(Character opened, Character closed) {
        if (opened == '(' && closed == ')') {
            return true;
        } else if (opened == '[' && closed == ']') {
            return true;
        } else if (opened == '{' && closed == '}') {
            return true;
        } else {
            return false;
        }
    }
}

package AV2.Stack;

import impl.Stack.LinkedStack;
import impl.Stack.Stack;

public class PostfixEval {
    public static void main(String[] args) {
        String expression = "59+2*";
        double result = evaluatePostfix(expression);
        System.out.println("Result: " + result);
    }

    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new LinkedStack<>();

        for (int i = 0; i < expression.length(); i++) {
            Character curr = expression.charAt(i);

            try {
                Double value = Double.parseDouble(curr.toString());
                stack.push(value);
            } catch (NumberFormatException e) {
                Double result = applyOperator(stack, curr);
                stack.push(result);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
        return stack.pop();
    }

    public static double applyOperator(Stack<Double> stack, Character operator) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        double b = stack.pop();
        double a = stack.pop();
        double result;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        return result;
    }

}

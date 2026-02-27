package main.java.service;
import main.java.domain.Stack;

public class InfixToPostfixConverter {

    public static String convert(String expression, Stack<Character> stack) {

        StringBuilder output = new StringBuilder();
        expression = expression.replaceAll("\\s+", "");

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    output.append(expression.charAt(i++));
                }
                output.append(" ");
                i--;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() &&
                        precedence(ch) <= precedence(stack.peek())) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    private static int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }
}
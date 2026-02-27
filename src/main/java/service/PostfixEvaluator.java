package main.java.service;

import main.java.domain.Stack;

public class PostfixEvaluator {

    public static double evaluate(String postfix, Stack<Double> stack) {

        String[] tokens = postfix.split(" ");

        for (String token : tokens) {

            if (token.matches("\\d+")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();

                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                    case '^': stack.push(Math.pow(a, b)); break;
                }
            }
        }

        return stack.pop();
    }
}
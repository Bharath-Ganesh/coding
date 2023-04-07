package com.leetcode.stackqueues;

import java.util.Stack;

/**
 * Convert an infix expression into prefix and postfix
 * exp "a*(b-c)/d+e"
 * postfix : abc-*d/e+
 * prefix  : +/*a-bcde
 */
public class _013_PrefixAndPostfixConversion {

    public static void main(String[] args) {
        String infixExp = "(((a*(b-c))/d)+e)";
        String postfix = postfixExp(infixExp);

        String prefix = prefixExp(infixExp);
        System.out.println("Postfix : " + postfix);
        System.out.println("Prefix : " + prefix);
    }

    public static String postfixExp(String exp) {

        Stack<Character> operator = new Stack<>();
        Stack<String> operand = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character ch = exp.charAt(i);
            if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                operand.push(ch + "");
            } else if (ch == '(') {
                operator.push(ch);
            } else if (ch == ')') {
                while (!operand.empty() && !operand.empty() && operator.peek() != '(') {
                    Character ope = operator.pop();
                    String postfixExp2 = operand.pop();
                    String postfixExp1 = operand.pop();
                    String postfixExp = postfixExp1 + postfixExp2 + ope;
                    operand.push(postfixExp);
                }
                operator.pop();
            } else {
                while (!operator.empty() && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch)) {
                    Character ope = operator.pop();
                    String postfixExp2 = operand.pop();
                    String postfixExp1 = operand.pop();
                    String postfixExp = postfixExp1 + postfixExp2 + ope;
                    operand.push(postfixExp);
                }
                operator.push(ch);
            }
        }

        while (!operator.empty()) {
            Character ch = operator.pop();
            String postfixExp2 = operand.pop();
            String postfixExp1 = operand.pop();
            String postfixExp = postfixExp1 + postfixExp2 + ch;
            operand.push(postfixExp);
        }
        return operand.pop();
    }

    public static String prefixExp(String exp) {
        StringBuilder prefixExp = new StringBuilder();
        Stack<Character> operator = new Stack<>();
        Stack<String> operand = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character ch = exp.charAt(i);
            if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                operand.push(ch + "");
            } else if (ch == '(') {
                operator.push(ch);
            } else if (ch == ')') {
                while (!operand.empty() && !operand.empty() && operator.peek() != '(') {
                    Character ope = operator.pop();
                    String postfixExp2 = operand.pop();
                    String postfixExp1 = operand.pop();
                    String postfixExp = ope + postfixExp1 + postfixExp2;
                    operand.push(postfixExp);
                }
                operator.pop();
            } else {
                while (!operator.empty() && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch)) {
                    Character ope = operator.pop();
                    String postfixExp2 = operand.pop();
                    String postfixExp1 = operand.pop();
                    String postfixExp = ope + postfixExp1 + postfixExp2;
                    operand.push(postfixExp);
                }
                operator.push(ch);
            }
        }

        while (!operator.empty()) {
            Character ope = operator.pop();
            String postfixExp2 = operand.pop();
            String postfixExp1 = operand.pop();
            String postfixExp = ope + postfixExp1 + postfixExp2;
            operand.push(postfixExp);
        }
        return operand.pop();
    }

    public static int operation(int num1, int num2, Character ch) {
        if (ch == '+') {
            return num1 + num2;
        } else if (ch == '*') {
            return num1 * num2;
        } else if (ch == '/') {
            return num1 / num2;
        } else if (ch == '-') {
            return num1 - num2;
        } else {
            return 0;
        }
    }

    public static int precedence(Character ch) {
        if (ch == '+') {
            return 1;
        } else if (ch == '*') {
            return 2;
        } else if (ch == '/') {
            return 2;
        } else if (ch == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}

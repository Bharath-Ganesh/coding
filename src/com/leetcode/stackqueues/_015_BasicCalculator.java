package com.leetcode.stackqueues;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 */
public class _015_BasicCalculator {

    public static void main(String[] args) {
        String exp = " 2-1 + 2 ";
        System.out.println(calculate(exp));
    }

    public static int calculate(String word) {

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int currNum = 0;
        boolean closingBracket = false;
        for (int i = 0; i < word.length(); i++) {
            Character currChar = word.charAt(i);
            if (Character.isWhitespace(currChar)) {
                continue;
            } else if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + currChar - '0';
            } else if (currChar == '(') {
                operators.push(currChar);
            } else if (currChar == ')') {
                operands.push(currNum);
                closingBracket = true;
                while (!operators.isEmpty() && operators.peek() != '(') {
                    Character ch = operators.pop();
                    int num2 = operands.pop();
                    int num1 = operands.pop();
                    int result = operation(num1, num2, ch);
                    operands.push(result);
                }
                operators.pop();
            }else {
                if (!closingBracket) {
                    operands.push(currNum);
                }
                closingBracket = false;
                operators.push(currChar);
                currNum = 0;
            }
        }
        if(currNum!=0){
            operands.push(currNum);
        }
        while (!operators.isEmpty() && operators.peek() != '(') {
            Character ch = operators.pop();
            int num2 = operands.pop();
            int num1 = operands.pop();
            int result = operation(num1, num2, ch);
            operands.push(result);
        }
        return operands.pop();
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
}

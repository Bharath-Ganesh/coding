package com.leetcode.stackqueues;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/find-expression-duplicate-parenthesis-not/
 * <p>
 * Given a balanced expression, find if it contains duplicate parenthesis or not.
 * A set of parenthesis are duplicate if the same subexpression is surrounded by multiple parenthesis.

 * Input : ((a+b)+((c+d)))
 * output : true
 * <p>
 *
 * The subexpression "a+(b)" is surrounded by two
 * pairs of brackets.
 * <p>
 * (((a+(b))+c+d))
 * The whole expression is surrounded by two
 * pairs of brackets.
 * <p>
 * ((a+(b))+(c+d))
 * (b) and ((a+(b)) is surrounded by two
 * pairs of brackets.
 * <p>
 * Below expressions don't have any duplicate parenthesis -
 *
 * No subsexpression is surrounded by duplicate
 * brackets.
 */
public class _005_FindDuplicateParenthesis {

    public static void main(String[] args) {
        String exp = "((a+b)+(c+d))";
        if (findDuplicateparenthesis(exp)) {
            System.out.println("Duplicates");
        } else {
            System.out.println("No Duplicates");
        }

    }

    static boolean findDuplicateparenthesis(String exp) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character ch = exp.charAt(i);
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    return true;
                }
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return false;
    }
}

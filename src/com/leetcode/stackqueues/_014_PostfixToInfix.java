package com.leetcode.stackqueues;

import java.util.Stack;


/**
 * Convert a postfix expression into infix and prefix
 * exp "abc-*d/e+"
 * infix : (((a*(b-c))/d)+e)
 * prefix  : +/*a-bcde
 */
public class _014_PostfixToInfix {

    public static void main(String[] args) {
        String postfix = "abc-*d/e+";
        String infixExp = infixExp(postfix);
        String prefix = prefixExp(postfix);
        System.out.println("Infix : " + infixExp);
        System.out.println("Prefix : " + prefix);
    }

    public static String infixExp(String exp) {
        Stack<String> infix = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character ch = exp.charAt(i);
            if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                infix.push(ch + "");
            } else {
                String infixExp2 = infix.pop();
                String infixExp1 = infix.pop();
                String infixExp = "(" + infixExp1 + ch + infixExp2 + ")";
                infix.push(infixExp);
            }
        }
        return infix.pop();
    }

    public static String prefixExp(String exp) {
        Stack<String> prefix = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            Character ch = exp.charAt(i);
            if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                prefix.push(ch + "");
            } else {
                String prefixExp2 = prefix.pop();
                String prefixExp1 = prefix.pop();
                String prefixExp = ch + prefixExp1 + prefixExp2;
                prefix.push(prefixExp);
            }
        }
        return prefix.pop();
    }

}

package com.practice.uiuc;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args) {
        ReversePolishNotation obj =  new ReversePolishNotation();
        String[] words = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(obj.evalRPN(words));
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String word: tokens){

            if(word.matches("-?\\d+")) {
                stack.push(Integer.valueOf(word));
            }else {
                int element2 = stack.pop();
                int element1 = stack.pop();
                int result = evalRPN(element1, element2, word);
                stack.push(result);
            }
        }
        return stack.peek();

    }

    private int evalRPN(int element1, int element2, String operator){

        if(operator.equals("+")){
            return element1 + element2;
        }else if(operator.equals("*")) {
            return element1 * element2;
        }else if(operator.equals("/")) {
            return element1 / element2;
        }else {
            return element1 - element2;
        }
    }
}

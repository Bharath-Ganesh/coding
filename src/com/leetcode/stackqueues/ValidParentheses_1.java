package com.leetcode.stackqueues;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Input: s = "()[]{}"
 * Output: true
 */
public class ValidParentheses_1 {
    public static void main(String[] args) {
        String expression="([)]";
        System.out.println(isValidLeetcode(expression));
    }

    public static  boolean isValidLeetcode(String s) {

        if(s.length()%2!=0)
            return false;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            Character bracket=s.charAt(i);
            if(bracket=='{' )
                stack.push('}');
            else if(bracket=='(')
                stack.push(')');
            else if(bracket=='[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop()!=bracket)
                return false;
        }
        return stack.isEmpty();

    }

    public static boolean isValid(String s) {

        Stack<Character> stack=new Stack<>();
        boolean isValid=false;
        for(int i=0;i<s.length();i++){
            Character bracket=s.charAt(i);
            if(bracket=='{' || bracket=='[' || bracket=='('){
                stack.push(bracket);
            }else if(bracket==']' ){
                isValid=checkParentheses(stack,'[');
                if(!isValid)
                    return false;
            }else if(bracket==')'){
                isValid=checkParentheses(stack,'(');
                if(!isValid)
                    return false;
            }else{
                isValid=checkParentheses(stack,'{');
                if(!isValid)
                    return false;
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }

    public static boolean checkParentheses(Stack stack,Character expected){

        if(stack.isEmpty()){
            return false;
        }
        if(stack.peek().equals(expected)){
            stack.pop();
        }else{
            return false;
        }
        return true;
    }
}

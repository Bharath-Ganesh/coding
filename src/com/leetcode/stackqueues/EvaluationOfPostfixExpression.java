package com.leetcode.stackqueues;

import java.util.Stack;

public class EvaluationOfPostfixExpression {
    public static void main(String[] args) {
        String word = "248-*4/8+";
        System.out.println(evaluatePostFix(word));
    }

    public static int evaluatePostFix(String word)
    {
        // Your code here
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<word.length();i++){
            Character ch=word.charAt(i);
            if(Character.isDigit(ch)){
                stack.push(ch-'0');
            }else{
                if(stack.size()>=2){
                    int num2=stack.pop();
                    int num1=stack.pop();
                    int res=evaluatePostFix(num1,num2,ch);
                    stack.push(res);
                }
            }
        }

        return stack.pop();
    }


    public static int evaluatePostFix(int num1,int num2,char operation){
        // Your code here
        if(operation=='+'){
            return num1+num2;
        }else if(operation=='-'){
            return num1-num2;
        }else if(operation=='*'){
            return num1*num2;
        }else if(operation=='/'){
            return num1/num2;
        }else{
            return 0;
        }
    }
}

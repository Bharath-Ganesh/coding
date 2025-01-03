package com.practice.uiuc.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class MyAtoi {

    public static void main(String[] args) {
        MyAtoi obj = new MyAtoi();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        // -2147483648  -2147483649
        System.out.println(obj.myAtoi("  -042"));
    }
    public int myAtoi(String s) {
        // 1337c0d3
        // -042
        // 42

        int n = s.length();
        int index = 0;
        long multiplier = 1L;
        long num = 0;
        while (index < n) {

            Character ch = s.charAt(index);
            if(Character.isWhitespace(ch)){
                // do nothing
            }
            else if(ch == '+' || ch == '-'){
                multiplier = ch == '+'? 1: -1;
                if(index + 1 < n && Character.isDigit(s.charAt(index+1))){
                    return doTheMath(s, n, index + 1, multiplier, num);
                }else {
                    return 0;
                }
            }else if(Character.isDigit(ch)){
                return doTheMath(s, n, index, multiplier, num);
            } else {
                return 0;
            }
            index++;
        }
        return 0;
    }

    private int doTheMath(String s, int n, int index, long multiplier, long num) {
        while(index < n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            num = num * 10 + digit;

            if(multiplier == -1){
                if(num >= (long) Integer.MAX_VALUE+1) {
                    return Integer.MIN_VALUE;
                }
            }else {
                if(num >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
            index++;
        }
        return (int) (num * multiplier);
    }

}

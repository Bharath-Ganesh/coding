package com.leetcode.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeStrings {

    public static void main(String[] args) {
        DecodeStrings obj = new DecodeStrings();
        String word = "3[a2[c]]";
        System.out.println(obj.decodeString(word));
    }

    public String decodeString(String s) {

        int n = s.length();
        Stack<String> result = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        String res = "";
        int index = 0;
        while (index < n) {
            Character ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + s.charAt(index) - '0';
                    index += 1;
                }
                counts.push(count);
            } else if (ch == '[') {
                result.push(res);
                res = "";
                index += 1;
            } else if (ch == ']') {
                StringBuilder word = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    word.append(res);
                }
                res=word.toString();
                index++;
            } else {
                res += ch;
                index++;
            }
        }
        return res;
    }
}

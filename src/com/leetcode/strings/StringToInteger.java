package com.leetcode.strings;

public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger obj = new StringToInteger();
        String word = "            42-";
        System.out.println(obj.myAtoi(word));
    }

    public int myAtoiOwn(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        long res = 0;
        int sign = 1;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            Character ch = word.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch == '+' || ch == '-') {
                if (ch == '-') {
                    sign = -1;
                }
                if (i + 1 < n && !Character.isDigit(word.charAt(i + 1))) {
                    return 0;
                }
            } else if (!Character.isDigit(ch)) {
                return 0;
            } else {
                while (i < n) {
                    Character val = word.charAt(i);
                    if (!Character.isDigit(val)) {
                        break;
                    }
                    int value = val - '0';
                    res = res * 10 + value;
                    if (sign == 1) {
                        if (res > Integer.MAX_VALUE) {
                            return Integer.MAX_VALUE;
                        }
                    } else {
                        if (res * -1 < Integer.MIN_VALUE) {
                            return Integer.MIN_VALUE;
                        }
                    }
                    i++;
                }
                break;
            }
        }
        return (int) res * sign;
    }

    public int myAtoi(String word) {

        if (word == null || word.length() > 200) {
            return 0;
        }

        int start = 0;
        int n = word.length();

        //remove the leading spaces;
        while (start < n && word.charAt(start) == ' ') {
            start++;
        }

        //if it contains only white spaces
        if (start == n) {
            return 0;
        }

        int sign = 1;

        if (word.charAt(start) == '-') {
            sign = -1;
            start++;
        } else if (word.charAt(start) == '+') {
            sign = 1;
            start++;
        }

        long res = 0;
        while (start < n) {
            char ch = word.charAt(start);
            if (!Character.isDigit(ch)) {
                break;
            }
            res = res * 10 + ch - '0';
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            start++;
        }
        return (int) res * sign;
    }
}


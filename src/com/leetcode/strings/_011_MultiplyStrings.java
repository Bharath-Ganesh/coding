package com.leetcode.strings;

/**
 * 43. Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */
public class _011_MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num2.length() > num1.length()) {
            return multiply(num2, num1);
        }
        Integer product = 0;

        String[] numArray = new String[num2.length()];
        int index = 0;
        //number multiplied with
        int j = num2.length() - 1;
        int carry = 0;
        while (j >= 0) {
            Integer number2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
            StringBuilder num = new StringBuilder();
            int i = num1.length() - 1;
            while (i >= 0) {
                Integer number1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
                product = number1 * number2 + carry;
                num.append(product % 10);
                carry = product / 10;
                i--;
            }

            while (carry != 0) {
                num.append(carry % 10);
                carry = carry / 10;
            }
            numArray[index++] = num.reverse().toString();
            j--;
        }

        for (int i=0;i<numArray.length;i++){

        }
        return "product";

    }

}

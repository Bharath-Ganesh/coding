package com.practice.uiuc.bits;

public class FindTheDifference {

    public static void main(String[] args) {
        FindTheDifference obj = new FindTheDifference();
        String s = "abcd", t = "abcde";
        System.out.println(obj.findTheDifference(s, t));
    }


    public char findTheDifference(String word1, String word2) {

        int sum = 0;
        for(int i = 0; i < word1.length(); i++){
            int num1 = word1.charAt(i) - 'a';
            int num2 = word2.charAt(i) - 'a';
            sum = sum ^ num1 ^ num2;
        }
        // Integer to Character
        sum = sum ^ (word2.charAt(word1.length()) - 'a');
        return (char) (sum + 'a');
    }
}

package com.leetcode.stackqueues;

import java.util.HashMap;
import java.util.Map;

public class Trial {
    public static void main(String[] args) {
        Map<String, Integer> accountMap = new HashMap<>();
        String word = "0P";
        Trial obj = new Trial();
        System.out.println(obj.isPalindrome(word));
    }

    public boolean isPalindrome(String s) {


        StringBuilder word  = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)){
                word.append(Character.toLowerCase(ch));
            }
        }

        return checkIfPalindrome(word);
    }

    private boolean checkIfPalindrome(StringBuilder word) {

        int low = 0;
        int high =  word.length() -1 ;

        while (low<high){
            if(word.charAt(low)!=word.charAt(high)){
                return false;
            }
            low++;high--;
        }
        return true;
    }
}

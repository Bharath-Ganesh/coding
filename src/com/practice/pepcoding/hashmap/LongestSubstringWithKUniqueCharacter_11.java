package com.practice.pepcoding.hashmap;



/**
 * Find the longest substring which is having exactly k unique characters.
 *
 * Given a string you need to print longest possible substring that has exactly M unique characters.
 * If there are more than one substring of longest possible length, then print any one of them.
 *
 * Input
 *      String expression="aabcbcdbca"
 *      int k=2;
 * ouput
 *      bcbc
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacter_11 {

    public static void main(String[] args) {
        String expression = "aabcbcdbca";
        int k=2;
        String answer = longestSubstringWithKUniqueCharacter(expression,k);
        System.out.println(answer);
    }

    private static String longestSubstringWithKUniqueCharacter(String expression,int k) {
        String longestSubstring = "";
        int i = -1;
        int j = -1;
        int maxLength=-1;
        Map<Character, Integer> map = new HashMap<>();
        while (true) {

            boolean flag1 = false;
            boolean flag2 = false;
            while (i < expression.length() - 1) {
                flag1 = true;
                i++;
                Character ch = expression.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if(map.size()==(k+1)){
                    break;
                }else if(map.size()==k){
                    String currExpression=expression.substring(j+1,i+1);
                    if(currExpression.length() > maxLength){
                        maxLength=currExpression.length();
                        longestSubstring=currExpression;
                    }
                }

            }

            while (j < i && map.size()>k) {
                flag2 = true;
                j++;
                Character ch = expression.charAt(j);
                int freq=map.get(ch);
                if(freq==1){
                    map.remove(ch);
                    break;
                }else{
                    map.put(ch, map.getOrDefault(ch, 0) -1);
                }

            }

            if (!flag1 && !flag2) {
                break;
            }
        }

        return longestSubstring;
    }

}

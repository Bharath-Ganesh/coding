package com.practice.pepcoding.hashmap;


/**
 * Find the longest substring with atmost k distinct characters
 * String expression="aabcbcdbca";
 * k=2
 * substring  :
 * aa , aab, bcbc
 * output : 4 (bcbc)
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKCharacter_11a {

    public static void main(String[] args) {
        String expression = "aabcbcdbca";
        int k = 2;
        int answer = longestSubstringWithAtmostKCharacter(expression, k);
        System.out.println(answer);
    }

    private static Integer longestSubstringWithAtmostKCharacter(String expression, int k) {
        int maxLength = 0;
         //window
        int i=-1;
        int j=-1;
        String longestSubstring = "";
        //map
        Map<Character,Integer> map= new HashMap<>();

        while (true){
            boolean flag1=true;
            boolean flag2=true;

            while(i<expression.length()-1){
                flag1=false;
                i++;
                Character ch = expression.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size()== (k+1)){
                    break;
                }else{

                    String currExpression=expression.substring(j+1,i+1);
                    if(currExpression.length() > maxLength){
                        maxLength=currExpression.length();
                        longestSubstring=currExpression;
                    }
                }

            }

            while (j<i ){
                flag2 = false;
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

            if(flag1 && flag2){
                break;
            }
        }
        System.out.println(longestSubstring);
        return maxLength;
    }


}

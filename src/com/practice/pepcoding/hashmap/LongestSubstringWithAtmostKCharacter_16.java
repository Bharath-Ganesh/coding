package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the longest substring with at most k unique characters
 *
 * String exp ="ddacbbaccdedacebb" and k=3;
 * output :
 * acbbacc (7)
 */
public class LongestSubstringWithAtmostKCharacter_16 {
    public static void main(String[] args) {
        String exp = "ddacbbaccdedacebb";
        int k=3;
        String answer = longestSubstringWithAtmostKCharacter(exp,k);
        System.out.println(answer);
    }

    private static String longestSubstringWithAtmostKCharacter(String exp,Integer k) {
        String answer="";
        int maxLength=0;
        //map for acquiring characters
        Map<Character,Integer> charFreqMap= new HashMap<>();

        //window pointer
        int i=-1;
        int j=-1;

        while (true) {

            boolean flag1 = false;
            boolean flag2 = false;

            while (i < exp.length() - 1) {
                flag1 = true;
                i++;
                Character ch = exp.charAt(i);
                charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);

                if(charFreqMap.size()==(k+1)){
                    break;
                }else {
                    String currExpression=exp.substring(j+1,i+1);
                    if(currExpression.length() > maxLength){
                        maxLength=currExpression.length();
                        answer=currExpression;
                    }
                }

            }

            while (j < i && charFreqMap.size()>k) {
                flag2 = true;
                j++;
                Character ch = exp.charAt(j);
                charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) -1);

                if(charFreqMap.get(ch)==0){
                    charFreqMap.remove(ch);
                    break;
                }
            }

            if (!flag1 && !flag2) {
                break;
            }
        }
        System.out.println("Length of the substring : "+maxLength);
        return answer;
    }
}

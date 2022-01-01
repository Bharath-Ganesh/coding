package com.practice.pepcoding.hashmap;


import java.util.HashMap;
import java.util.Map;

/**
 * Find the count of all substring which is having distinct characters
 * String exp1= aabcbcdbca
 * Output = 24 (a, a, ab , b, abc, bc, c, cb, b, bc ,c, bcd , cd, d, cdb, db, b , dbc, bc , c , dbca , bca, ca , a)
 */

public class CountOfAllSubstringsWithoutRepeatition_10 {

    public static void main(String[] args) {
        String exp1 = "aabcbcdbca";
        int count = countOfAllSubstringsWithoutRepeatition(exp1);
        System.out.printf("Total count : %d", count);
    }

    private static int countOfAllSubstringsWithoutRepeatition(String exp1) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            //acquire
            while (i < exp1.length() - 1) {
                flag1=true;
                i++;
                Character ch = exp1.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)==2){
                    break;
                }else{
                    count+=i-j;
                }
            }
            while (j < i) {
                flag2=true;
                j++;
                Character ch = exp1.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch)==1){
                    count+=i-j;
                    break;
                }
            }
            if (!flag1 && !flag2) {
                break;
            }
        }
        return count;
    }
}

package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1
 */
public class SmallestDistinctWindow {

    public static void main(String[] args) {
        SmallestDistinctWindow obj=new SmallestDistinctWindow();
        String word="AA";
        System.out.println(obj.findSubString(word));
    }

    public int findSubString(String word) {
        // Your code goes here
        Map<Character,Integer> desiredMap=new HashMap<>();
        int minLength=word.length();

        for(int i=0;i<word.length();i++){
            Character ch=word.charAt(i);
            desiredMap.put(ch,desiredMap.getOrDefault(ch,1)+1);
        }


        int desiredSize=desiredMap.size();
        int i=-1;
        int j=-1;

        Map<Character,Integer> map=new HashMap<>();
        while(true){
            boolean flag1=true;
            boolean flag2=true;

            while(i< (word.length()-1)){
                flag1=false;
                i++;
                Character ch=word.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size()==desiredSize){
                    break;
                }
            }

            while(j<i && map.size()==desiredSize){
                flag2=false;
                minLength=Math.min(minLength,i-j);
                j++;
                Character ch=word.charAt(j);
                int freq=map.get(ch);
                if(freq==1){
                    map.remove(ch);
                    break;
                }else{
                    map.put(ch,freq-1);
                }
            }
            if(flag1 && flag2){
                break;
            }
        }
        return minLength;
    }
}

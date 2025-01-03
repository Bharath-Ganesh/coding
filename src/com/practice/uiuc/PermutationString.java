package com.practice.uiuc;

import java.util.HashMap;
import java.util.Map;

public class PermutationString {

    public static void main(String[] args) {
        PermutationString obj = new PermutationString();
        String s1 = "ab", s2 = "boa";
        System.out.println(obj.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> desiredMap = new HashMap<>();
        Map<Character, Integer> currMap = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            Character ch = s1.charAt(i);
            desiredMap.put(ch , desiredMap.getOrDefault(ch, 0) + 1);
        }

        int length = s1.length();
        int desiredFreq = 0;
        int left = 0;
        int n = s2.length();

        for(int right = 0; right < n; right++){

            // ebaooo
            Character currChar = s2.charAt(right);
            currMap.put(currChar, currMap.getOrDefault(currChar, 0) + 1);

            if(desiredMap.getOrDefault(currChar, 0) >= currMap.get(currChar)) desiredFreq++;


            if((right-left) + 1 >= length) {
                if(desiredFreq == s1.length()) return true;

                Character charToBeRemoved = s2.charAt(left);
                int freqCount = currMap.get(charToBeRemoved);
                int desiredCount = desiredMap.getOrDefault(charToBeRemoved, 0);

                // the element exist
                if(desiredCount > 0){
                    desiredFreq--;
                }

                if(freqCount == 1) currMap.remove(charToBeRemoved);
                else currMap.put(charToBeRemoved, freqCount - 1 );
                left++;

            }
        }
        return false;
    }
}

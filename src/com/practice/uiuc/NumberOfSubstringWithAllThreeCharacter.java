package com.practice.uiuc;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringWithAllThreeCharacter {

    public static void main(String[] args) {
        NumberOfSubstringWithAllThreeCharacter obj  = new NumberOfSubstringWithAllThreeCharacter();
        String word = "acbbcac";
        System.out.println(obj.numberOfSubstrings(word));
    }

    public int numberOfSubstrings(String word) {

        int count[] = {0, 0, 0};
        int  res = 0 , left = 0;
        int n = word.length();
        for (int right = 0; right < n; right++) {

            ++count[word.charAt(right) - 'a'];
            // all the characters exist at least once
            while (count[0] > 0 && count[1] > 0 && count[2] > 0){
                --count[word.charAt(left++) - 'a'];
            }
            res += left;
        }
        return res;
    }
}

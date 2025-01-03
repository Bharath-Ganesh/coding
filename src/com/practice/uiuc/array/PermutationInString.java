package com.practice.uiuc.array;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();
        System.out.println(obj.checkInclusion("bbb", "acbbb"));
    }

    public boolean checkInclusion(String s1, String s2) {

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) return false;

        for(int i=0; i<n1; i++){
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }

        int matches = 0;
        for(int i=0; i<26; i++){
            if(s1Count[i]==s2Count[i]) matches++;
        }

        int left = 0, right = n1;

        while(right < n2){

            if(matches == 26) return true;
            int index = s2.charAt(right)-'a';

            s2Count[index]--;
            if(s2Count[index] == s1Count[index]) matches++;
            else if(s2Count[index] == s1Count[index] - 1) matches--;


            index = s2.charAt(left)-'a';
            s2Count[index]++;
            if(s2Count[index] == s1Count[index]) matches++;
            else if(s2Count[index] == s1Count[index] + 1) matches--;




            left++;
            right++;
        }
        return matches == 26;
    }
}

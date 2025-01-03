package com.practice.uiuc;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        System.out.println(obj.characterReplacement("ABABBA", 2));
    }

    public int characterReplacement(String s, int k) {

        int[] freqMap = new int[26];
        int n = s.length();
        int maxFreq = 0;
        int maxLength = 0;
        int left = 0;
        int right = 0;

        while (right < n) {

            Character ch = s.charAt(right);
            freqMap[ch - 'A']++;
            maxFreq = Math.max(freqMap[ch - 'A'], maxFreq);

            int length = (right - left) + 1;
            int changes = length - maxFreq;
            if(changes <= k){
                maxLength = Math.max(length, maxLength);
            }else{
                while(left < right) {
                    Character ch1 = s.charAt(left);
                    freqMap[ch1 - 'A']--;
                    maxFreq = Math.max(freqMap[ch - 'A'], maxFreq);
                    length = (right - left) + 1;
                    changes = length - maxFreq;
                    left++;
                    if(changes <= k){
                        break;
                    }
                }
            }
            right++;
        }
        return maxLength;
    }

//    public int characterReplacement(String s, int k) {
//
//        int[] freqMap = new int[26];
//        int n = s.length();
//        int maxFreq = 0;
//        int maxLength = 0;
//        int left = 0;
//        int right = 0;
//
//        while (right < n) {
//
//            Character ch = s.charAt(right);
//            freqMap[ch - 'A']++;
//            maxFreq = Math.max(freqMap[ch - 'A'], maxFreq);
//            int length = (right - left) + 1;
//            int changes = length - maxFreq;
//            while (changes > k){
//                Character ch1 = s.charAt(left);
//                freqMap[ch1 - 'A']--;
//                maxFreq = 0;
//                for(int i=0; i<=25 ; i++)
//                maxLength = Math.max(length, maxLength);
//                maxFreq = Math.max(freqMap[ch - 'A'], maxFreq);
//            }
//            if (changes <=k ){
//                maxLength = Math.max(maxLength, length);
//            }
//            right++;
//        }
//        return maxLength;
//    }
}

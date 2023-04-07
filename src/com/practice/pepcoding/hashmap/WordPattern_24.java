package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays of strings , find the two strings are of one-one mapping nature.
 String[] arr1 = {"a",  "b",   "b",   "c",   "a",    "a" };
 String[] arr2 = {"the","pep","pep","coding","that","the"};
 Output:
 false

 String[] arr1 = {"a",  "b",   "b",   "c", "a",  "a" };
 String[] arr2 = {"the","pep","pep","the","the","the"};
 Output:
 false

 String[] arr1 = {"a",  "b",   "b",   "c",    "a",  "a" };
 String[] arr2 = {"the","pep","pep","coding","the","the"};
 Output:
 true
 */
public class WordPattern_24 {
    public static void main(String[] args) {
        String[] arr1 = {"a",  "b","b",   "c",    "a",  "a" };
        String[] arr2 = {"the","pep","pep","coding","the","the"};
        boolean isOneToOne=wordPattern(arr1,arr2);
        if (isOneToOne) {
            System.out.println("Two strings are mapped");
        } else {
            System.out.println("They are not mapped!");
        }
    }

    private static boolean wordPattern(String[] arr1, String[] arr2) {
        boolean isOneToOne=false;

        if(arr1.length!= arr2.length){
            return isOneToOne;
        }

        Map<Character,String> charMap= new HashMap<>();
        Map<String,Boolean> isCharMap=new HashMap<>();

        for(int i=0;i<arr1.length;i++){
            Character ch= arr1[i].charAt(0);
            String word=arr2[i];

            if(charMap.containsKey(ch)){
                if(charMap.get(ch)!=word){
                    return isOneToOne;
                }
            }else{
                charMap.put(ch,word);
                if(isCharMap.getOrDefault(word,false)){
                    return isOneToOne;
                }else{
                    isCharMap.put(word,true);
                }

            }
        }
        return true;
    }
}

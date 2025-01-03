package com.practice.uiuc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecode {

    public static void main(String[] args) {
        EncodeAndDecode obj = new EncodeAndDecode();
       // List<String> list = Arrays.asList("neet","code","love","you");
         List<String> list = Arrays.asList("we","say",":","yes","aaaaaaaaaaaaaaaaaaaa");
        String result = obj.encode(list);
        System.out.println(obj.decode(result));
    }



    private void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }



    private static final Character CONST = '#';

    public String encode(List<String> strs) {

        StringBuilder encodeString = new StringBuilder();
        for(String word : strs){
            int len = word.length();
            encodeString.append(len);
            encodeString.append(CONST);
            encodeString.append(word);
        }
        return encodeString.toString();
    }

    public List<String> decode(String str) {

        List<String> results = new ArrayList<>();
        int index = 0;
        int n =  str.length();
        while(index < n) {
            String digits = findIndex(str, index);
            index += digits.length() + 1;
            int length = Integer.parseInt(digits);
            String word = str.substring(index, index + length);
            results.add(word);
            index += length;
        }

        return results;
    }

    private String findIndex(String word, int low){
        String index = "";
        for(int i = low; i < word.length(); i++){
            Character ch = word.charAt(i);
            if(ch == CONST) break;
            index += ch;
        }
        return index;
    }

//    Character DELIMITER = '#';
//    public String encode(List<String> strs) {
//
//        StringBuilder encodedString = new StringBuilder();
//        for(String word:  strs){
//            int len = word.length();
//            encodedString.append(len);
//            encodedString.append(DELIMITER);
//            encodedString.append(word);
//        }
//        return encodedString.toString();
//    }
//
//    public List<String> decode(String str) {
//
//        List<String> decodedList = new ArrayList<>();
//        int index = 0;
//
//        while (index < str.length()) {
//            // Extract the length of the next word
//            int delimiterPos = str.indexOf(DELIMITER, index);
//            int length = Integer.parseInt(str.substring(index, delimiterPos));
//            index = delimiterPos + 1;  // Move past the delimiter
//
//            // Extract the word
//            String word = str.substring(index, index + length);
//            decodedList.add(word);
//            index += length;  // Move to the next encoded word
//        }
//
//        return decodedList;
//    }
}

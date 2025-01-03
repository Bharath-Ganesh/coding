package com.practice.uiuc.strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords obj = new ReverseWords();
        System.out.println(obj.reverseWords("EPY2giL"));
    }

    public String reverseWords(String s) {

        int n = s.length();
        List<String> result = new ArrayList<>();
        int start;
        int end = 0;
        while(end < n) {

            // starting blank space
            while (end < n && Character.isWhitespace(s.charAt(end))){
                end++;
            }
            start = end;

            while(end < n && !Character.isWhitespace(s.charAt(end))){
                end++;
            }
            String word = s.substring(start, end);
            result.add(word);

            // trailing blank space
            while (end < n && Character.isWhitespace(s.charAt(end))){
                end++;
            }
        }

        StringBuilder output = new StringBuilder();
        for(int i = result.size()-1; i>=0; i--){
            output.append(result.get(i));
            if(i>0){
                output.append(" ");
            }
        }
        return output.toString();
    }
}

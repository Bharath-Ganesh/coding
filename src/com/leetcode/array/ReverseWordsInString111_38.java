package com.leetcode.array;

/**
 * 557. Reverse Words in a String III
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInString111_38 {

    public static void main(String[] args) {
        String word = "Let's take LeetCode contest";
        System.out.println(reverseWordsOptimum(word));
    }

    public static String reverseWordsOptimum(String words) {

        //words to character array
        char[] res = words.toCharArray();
        int start=0;
        int end=0;
        for(int i=0;i<res.length;i++){
            char ch=res[i];
            if(ch==' '){
                end=i-1;
                reverse(res,start,end);
                start=i+1;
            }
        }
        reverse(res,start,res.length-1);
        return new String(res);
    }

    private static void reverse(char[] c, int start, int end){
        while(start < end){
            char tmp = c[end];
            c[end] = c[start];
            c[start] = tmp;
            start++;
            end--;
        }
    }

    public static String reverseWords(String s) {

        //String concatenation is a costly process
        StringBuilder output=new StringBuilder();
        String[] words=s.split(" ");
        for(int i=0;i<words.length-1;i++){
            StringBuilder wd=new StringBuilder(words[i]);
            output.append(wd.reverse());
            output.append(" ");
        }
        output.append(new StringBuilder(words[words.length-1]).reverse());
        return output.toString();
    }
}

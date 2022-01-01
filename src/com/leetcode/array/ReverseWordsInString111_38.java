package com.leetcode.array;

/**
 * 557. Reverse Words in a String III
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInString111_38 {

    public static void main(String[] args) {
        ReverseWordsInString111_38 obj = new ReverseWordsInString111_38();
        String word = "3wmUdH   TABeXl      9WC3AtZVX  xDu     yupBX   pD  O4scD3ML   DXOWwI     xOS1     o3ndHsfHg   qgfBeci     PYBSK     xM  RFyzvkDt9V     8jrRY     J1evYz  MuAkSH9pT   FvdcS6   WUsdNRYo v8";
        System.out.println(obj.reverseWordsNew(word));
    }

    public String reverseWordsNew(String word) {
        if (word.isEmpty()) {
            return word;
        }
        StringBuilder res = new StringBuilder();

        int n = word.length();
        boolean isWord = false;
        int finalPos = n;
        for (int i = n - 1; i >= 0; i--) {
            Character ch = word.charAt(i);
            if (Character.isAlphabetic(ch)) {
                //Character is an alphabet
                if (!isWord) {
                    isWord = true;
                    finalPos = i;
                }

            } else {
                if (isWord) {
                    //update the word
                    String currWord = word.substring(i + 1, finalPos + 1);
                    res.append(currWord + " ");
                    isWord = false;
                }
            }
        }
        if (Character.isAlphabetic(word.charAt(0))) {
            String currWord = word.substring(0, finalPos + 1);
            res.append(currWord);
        } else {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    public String reverseWords(String s) {
        if(s==null){
            return "";
        }

        int n=s.length();
        char[] arr=s.toCharArray();
        //reverse the array from start to end
        reverse(arr,0,n-1);
        // reverse all the words from start till end
        reverseWords(arr);
        //remove the leading, trailing, and multiple spaces
        return cleanSpaces(arr);
    }

    public String cleanSpaces(char[] arr){
        int start=0;
        int end=0;
        int n=arr.length;

        while(end<n){

            // skip the white space
            while(end<n && arr[end]==' '){
                end++;
            }

            //fill up the words from the start
            while(end<n && arr[end]!=' '){
                arr[start++]=arr[end++];
            }

            //remove the trailing spaces
            while(end<n && arr[end]==' '){
                end++;
            }

            if(end<n){
                arr[start++]=' ';
            }
        }
        return new String(arr).substring(0,start);
    }

    public void reverseWords(char[] arr){
        int start=0;
        int end=0;
        int n=arr.length;
        //skip spaces
        while(start<n){
            while(start<end || start<n && arr[start]==' '){
                start++;
            }
            while(end<start || end<n && arr[end]!=' '){
                end++;
            }
            reverse(arr,start,end-1);
        }
    }

    public void reverse(char[] arr,int i,int j){
        while(i<j){
            char ch=arr[i];
            arr[i]=arr[j];
            arr[j]=ch;
            i++;j--;
        }
    }
}

package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * <p>
 * Input: s = "a"
 * Output: [["a"]]
 */
public class _014_PalindromePartitioning {

    public static void main(String[] args) {
        _014_PalindromePartitioning obj=new _014_PalindromePartitioning();
        String word = "aab";
        System.out.println(obj.partition(word));
    }

    public List<List<String>> partition(String s) {

        List<List<String>> result=new ArrayList<>();
        int index=0;
        List<String> partition=new ArrayList<>();
        partition(s,result,partition,index);
        return result;
    }

    public void partition(String word,List<List<String>> result,List<String> partition,int index) {

        if(index==word.length()){
            result.add(new ArrayList<>(partition));
            return;
        }

        for(int i=index;i<word.length();i++){
            String currWord=word.substring(index,i+1);
            if(isPalindrome(currWord)){
                partition.add(currWord);
                partition(word,result,partition,i+1);
                partition.remove(partition.size()-1);
            }
        }

    }


    private boolean isPalindrome(String word){
        int start=0;
        int end=word.length()-1;
        while(start<end){
            if(word.charAt(start)!=word.charAt(end)){
                return false;
            }
            start++;end--;
        }
        return true;
    }

//    public static List<List<String>> partition(String word) {
//        List<List<String>> res=new ArrayList<>();
//        List<String> currList=new ArrayList<>();
//        partition(word,res,currList,0);
//        return res;
//    }
//
//    public static void partition(String word,List<List<String>> res,List<String> currList,int index) {
//
//        if(index==word.length()){
//            res.add(currList);
//            return;
//        }
//
//        for(int i=index;i<word.length();i++){
//            String substring=word.substring(index,i+1);
//            if(isPalindrome(substring)){
//                currList.add(substring);
//                partition(word,res,currList,i+1);
//                currList.remove(currList.size()-1);
//            }
//        }
//    }
//
//    private static boolean isPalindrome(String word){
//        int low=0;
//        int high=word.length()-1;
//        while(low<high){
//            if(word.charAt(low)!=word.charAt(high)){
//                return false;
//            }
//            low++;
//            high--;
//        }
//        return true;
//    }
}

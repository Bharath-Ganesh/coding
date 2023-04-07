package com.leetcode.strings;

/**
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumber {

    public static void main(String[] args) {
        CompareVersionNumber obj = new CompareVersionNumber();
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(obj.compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {

        int n=version1.length();
        int m=version2.length();

        int i=0,j=0;


        while(i<n && j<m){

            int val1=0;
            int val2=0;

            while(i<n && version1.charAt(i)!='.'){
                val1=val1*10+(version1.charAt(i)-'0');
                i++;
            }
            i++;

            while(j<m && version2.charAt(j)!='.'){
                val2=val2*10+(version2.charAt(j)-'0');
                j++;
            }

            j++;

            if(val1>val2){
                return 1;
            }else if(val1<val2){
                return -1;
            }
        }
        return 0;
    }
}

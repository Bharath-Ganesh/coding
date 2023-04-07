package com.leetcode.array;

/**
 * 278. First Bad Version
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product
 * fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 *
 */
public class FirstBadVersion_24 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(10));

    }

    public static int firstBadVersion(int n) {

        if(n==1 || n==2){
            return 1;
        }
        int start=1;
        int last=n;
        if(!isBadVersion(n))
            return n;
        while(start<last){
            int mid=start+(last-start)/2;
            /** mid = (start+end)) / 2; **/
            if(isBadVersion(mid))
                last=mid;
            else  start=mid;
        }
        return last;
    }

    public static boolean isBadVersion(int version){
        if(version==6){
            return false;
        }
        return true;

    }
}

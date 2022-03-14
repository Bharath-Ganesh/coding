package com.leetcode.bits;

import java.util.Arrays;

/**
 * 1310. XOR Queries of a Subarray
 * You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].
 *
 * For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
 *
 * Return an array answer where answer[i] is the answer to the ith query.
 *
 * Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * Output: [2,7,14,8]
 * Explanation:
 * The binary representation of the elements in the array are:
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * The XOR values for queries are:
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 *
 * Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * Output: [8,0,4,4]
 *
 *
 * Input: arr = [16], queries = [[0,0],[0,0],[0,0]]
 * Output: [8,0,4,4]
 *
 *
 */
public class _006_XORQueriesOfSubarray {

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        System.out.println(Arrays.toString(xorQueries(arr,queries)));

    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result=new int[queries.length];
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=(prefix[i-1]^arr[i]);
        }
        System.out.println(Arrays.toString(prefix));
        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            if(left==0){
                result[i]=prefix[right];
            }else{
                result[i]=prefix[left-1]^prefix[right];
            }

        }
        return result;
    }
}

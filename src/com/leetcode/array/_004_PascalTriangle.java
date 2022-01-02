package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;


/**
 * 118. Pascal's Triangle
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class _004_PascalTriangle {

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generateLeetcode(numRows);
        System.out.println(result);
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static  List<List<Integer>> generateLeetcode(int numRows) {

        List<List<Integer>> res=new ArrayList<>();
        //1,2,3,4,5
        for(int i=1;i<=numRows;i++){
            List<Integer> row=new ArrayList<>();
            //0,1,2
            int j=0;
            for(j=0;j<i;j++){
                if(j==0 || j==i-1){
                    row.add(1);
                    continue;
                }
                List<Integer> prev=res.get(i-2);
                // k=1
                int k=0;
                for(k=1;k<prev.size();k++){
                    row.add(prev.get(k-1)+prev.get(k));
                }
                j=k-1;
            }
            res.add(row);
        }
        return res;
    }
}

package com.leetcode.stackqueues;

import java.util.Stack;

public class CelebrityProblem {

    public static void main(String[] args) {
        CelebrityProblem obj = new CelebrityProblem();
        int[][] arr = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}};
        System.out.println(obj.celebrity(arr, arr.length));
    }

    int celebrity(int matrix[][], int n) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int i = stack.pop();
            int j = stack.pop();
            if (matrix[i][j] == 1) {
                stack.push(j);
            } else {
                stack.push(i);
            }
        }
        int potentialCel = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != potentialCel) {
                if (matrix[i][potentialCel] != 1 || matrix[potentialCel][i] != 0) {
                    return -1;
                }
            }
        }
        return potentialCel;
    }
}

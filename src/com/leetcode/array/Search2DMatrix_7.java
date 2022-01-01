package com.leetcode.array;

/**
 * 74. Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 *  int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}; target = 3
 * Output: true
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
public class Search2DMatrix_7 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrixLeetcode(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                int element = matrix[i][j];
                if (element > target) {
                    break;
                } else if (element == target) {
                    return true;
                } else {
                    int lastElement = matrix[i][cols-1];
                    if (target > lastElement) {
                        return false;
                    } else {
                        binarySearch(matrix[i], target);
                    }
                }
            }
        }
        return false;
    }


    public static boolean binarySearch(int[] arr, int target) {
        int startIndex=0;
        int lastIndex=arr.length-1;
        while (startIndex<=lastIndex){
            int midIndex=(lastIndex-startIndex)/2+startIndex;
            if(target>arr[midIndex]){
                startIndex=midIndex+1;
            }else if(target<arr[midIndex]){
                lastIndex=midIndex-1;
            }else{
                return true;
            }
        }
        return false;
    }


    //Treat the matrix as a one-dimensional array
    public static boolean searchMatrixLeetcode(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int startIndex=0;
        int lastIndex=(rows*cols)-1;
        while (startIndex<=lastIndex){
            int midIndex=(lastIndex-startIndex)/2+startIndex;
            if(target>matrix[midIndex/cols][midIndex%cols]){
                startIndex=midIndex+1;
            }else if(target<matrix[midIndex/cols][midIndex%cols]){
                lastIndex=midIndex-1;
            }else{
                return true;
            }
        }
        return false;
    }



}

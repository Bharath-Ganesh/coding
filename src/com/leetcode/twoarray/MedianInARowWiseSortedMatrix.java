package com.leetcode.twoarray;

/**
 * Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.
 */
public class MedianInARowWiseSortedMatrix {

    public static void main(String[] args) {
        MedianInARowWiseSortedMatrix obj = new MedianInARowWiseSortedMatrix();

        //int[][] matrix = {{2, 2, 6, 11, 11, 11, 14, 19, 19}, {2, 8, 12, 13, 14, 15, 16, 17, 19}, {1, 2, 5, 6, 12, 13, 18, 20, 20}, {5, 5, 10, 11, 12, 15, 17, 17, 20}, {4, 5, 6, 9, 9, 11, 12, 17, 17}, {2, 4, 6, 10, 12, 14, 18, 18, 19}, {3, 3, 8, 8, 11, 13, 14, 15, 18}, {4, 7, 10, 15, 16, 17, 18, 19, 20}, {1, 1, 2, 10, 11, 12, 16, 17, 19}, {1, 1, 2, 5, 9, 10, 12, 16, 18}, {4, 6, 7, 8, 13, 14, 15, 15, 18}};
        //int[][] matrix = {{8, 11, 11, 12, 15}, {5, 10, 11, 11, 15}, {1 ,4, 13, 16, 17}, {4, 9, 10, 11, 12}, {1, 3, 4, 12, 13}};
        int[][] matrix = {{1 ,3 ,5},{ 2, 6, 9},{ 3 ,6, 9}};
        System.out.println(obj.median(matrix, matrix.length, matrix[0].length));
    }

    int median(int matrix[][], int R, int C) {
        // code here
        int low=1;
        int high=2000;
        int reqMedian = (R*C+1)/2;

        while(low<high){
            int mid=low+(high-low)/2;
            int median=findMedian(matrix,mid);
            if(median>=reqMedian){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }


    private int findMedian(int matrix[][],int element){

        int count=0;
        int col=matrix[0].length;

        for(int nums[] : matrix){

            int low=0;
            int high=col-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums[mid]>element){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            count+=low;
        }
        return count;

    }

//    public int median(int matrix[][], int r, int c) {
//        // code here
//        int n = (r * c);
//        int low = Integer.MAX_VALUE;
//        int high = Integer.MIN_VALUE;
//        for (int i = 0; i < r; i++) {
//            low = Math.min(low, matrix[i][0]);
//            high = Math.max(high, matrix[i][c - 1]);
//        }
//        int req = n / 2;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            int place = computePlace(mid, matrix);
//            if (place > req) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return low;
//
//    }
//
//    private int computePlace(int element, int[][] matrix) {
//        int totalElements = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            int low = 0;
//            int high = matrix[0].length - 1;
//            while (low <= high) {
//                int mid = low + (high - low) / 2;
//                if (matrix[i][mid] <= element) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//            totalElements += low;
//        }
//        return totalElements;
//
//    }
}

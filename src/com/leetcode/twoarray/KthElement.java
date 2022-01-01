package com.leetcode.twoarray;

/**
 * https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1
 */
public class KthElement {

    public static void main(String[] args) {
        int k = 7;
        int mat[][] =
                {{10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {24, 29, 37, 48},
                        {32, 33, 39, 50}};
        System.out.println(kthSmallest(mat, mat.length, k));
    }

    public static int kthSmallest(int[][] matrix, int n, int k) {
        //code here.
        int row = matrix.length;
        int col = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[row - 1][col - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int pos = binarySearch(matrix, mid);
            if (pos >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int binarySearch(int[][] matrix, int element) {
        int row = matrix.length;
        int col = matrix[0].length;
        int totalElements = 0;
        for (int i = 0; i < row; i++) {
            int low = 0;
            int high = col - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[i][mid] <= element) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            totalElements += low;
        }
        return totalElements;
    }

        /*
    //method 1: t.c. O(n) s.c. O(26)
    public String FirstNonRepeating(String A)
    {
        // map to store the character and its count
        Map<Character,Integer> count=new HashMap<Character,Integer>();
        Queue<Character> q=new LinkedList<>();
        StringBuilder s=new StringBuilder();
        for(char ch:A.toCharArray())
        {
            //insert the char ch and increment its count and add it to the queue
            count.put(ch,count.getOrDefault(ch,0)+1);
            q.add(ch);
            //after inserting every char, check if the front element count>1,then pop it else append peek in s
            while(!q.isEmpty())
            {
                if(count.get(q.peek())>1)
                q.poll();

                else{
                    s.append(q.peek());break;
                }
            }
            //q empty then push #
            if(q.isEmpty())
            s.append('#');
        }
        return s.toString();
    }*/

//    public static int kthSmallest(int[][] arr, int n, int k) {
//        int row = arr.length;
//        int col = arr[0].length;
//        int low = arr[0][0];
//        int high = arr[row - 1][col - 1];
//        while (low <= high) {
//            int mid = (high - low) / 2 + low;
//            int totalElements = computeKthElement(arr, mid);
//            if (totalElements >= k) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return low;
//    }
//
//    private static int computeKthElement(int[][] arr, int element) {
//        int kElement = 0;
//        for (int row = 0; row < arr.length; row++) {
//            int low = 0;
//            int high = arr.length - 1;
//            while (low <= high) {
//                int mid = low + (high - low) / 2;
//                int midElement = arr[row][mid];
//                if (midElement > element) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//
//                }
//            }
//            kElement += low;
//        }
//        return kElement;
//    }
}

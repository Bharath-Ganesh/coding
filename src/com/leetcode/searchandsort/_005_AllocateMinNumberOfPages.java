package com.leetcode.searchandsort;

import java.util.Arrays;

/**
 * Allocate minimum number of pages
 * https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1#
 * You are given N number of books. Every ith book has Ai number of pages.
 * <p>
 * You have to allocate contagious books to M number of students. There can be many ways or permutations to do so.
 * In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations,
 * the task is to find that particular permutation in which the maximum number of pages allocated to a student is the minimum of
 * those in all the other permutations and print this minimum value.
 * <p>
 * Each book will be allocated to exactly one student. Each student has to be allocated at least one book.
 * <p>
 * Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
 * <p>
 * N = 4
 * A[] = {12,34,67,90}
 * M = 2
 * Output:113
 * Explanation:Allocation can be done in
 * following ways:{12} and {34, 67, 90}
 * Maximum Pages = 191{12, 34} and {67, 90}
 * Maximum Pages = 157{12, 34, 67} and {90}
 * Maximum Pages =113. Therefore, the minimum
 * of these cases is 113, which is selected
 * as the output.
 * <p>
 * * N = 7
 * * A[] = {10,20,30,30,40,50,60}
 * int students=3
 * ouput : 3
 *
 *  int arr[] = {13 ,31, 37, 45, 46, 54, 55, 63, 73, 84, 85};
 *         int students = 9;
 */
public class _005_AllocateMinNumberOfPages {

    public static void main(String[] args) {
        int arr[] = {12 ,34 ,67, 90};
        int students = 5;
        System.out.println(findPages(arr, arr.length, students));
    }

    public static int findPages(int[] arr,int N,int m)
    {
        //Your code here
        int low=0;
        int high=0;
        for(int num : arr){
            low=Math.max(low,num);
            high+=num;
        }

        if(m>N){
            return -1;
        }
        int ans=-1;
        while(low<=high){
            int pages=(high-low)/2+low;
            if(isPossible(pages,arr,m)){
                ans=pages;
                high=pages-1;
            }else{
                low=pages+1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int minPages,int[] arr,int students){

        int totalPage=0;
        int totalStudents=1;
        for(int page : arr){
            totalPage+=page;
            if(totalPage>minPages){
                totalStudents+=1;
                totalPage=page;
            }

            if(totalStudents>students){
                return false;
            }
        }
        return true;
    }

//    public static int findPages(int[] arr, int N, int students) {
//        //Your code here
//        int minPages = findPartition(arr, students);
//        return minPages;
//    }
//
//
//
//
//    public static int findPartition(int[] arr, int students) {
//        int start = 0;
//        int end = Arrays.stream(arr).sum();
//        int minPages = -1;
//        while (start <= end) {
//            int mid = (end - start) / 2 + start;
//            if (isPossible(arr, students, mid)) {
//                minPages = mid;
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return minPages;
//    }
//
//    public static boolean isPossible(int[] arr, int students, int partition) {
//        int minStudents = 1;
//        int pages = 0;
//        for (int i = 0; i < arr.length; i++) {
//            pages += arr[i];
//            if (partition < pages) {
//                minStudents += 1;
//                if (minStudents > students || arr[i] > partition) {
//                    return false;
//                }
//                pages = arr[i];
//            }
//        }
//        return true;
//    }
}

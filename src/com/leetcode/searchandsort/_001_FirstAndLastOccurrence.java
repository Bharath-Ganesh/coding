package com.leetcode.searchandsort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
 * Given a sorted array arr containing n elements with possibly duplicate elements,
 * the task is to find indexes of first and last occurrences of an element x in the given array.
 * <p>
 * Input:
 * n=9, x=5
 * arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
 * Output:  2 5
 * Explanation: First occurrence of 5 is at index 2 and last
 * occurrence of 5 is at index 5.
 * <p>
 * Input:
 * n=9, x=7
 * arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
 * Output:  6 6
 */
public class _001_FirstAndLastOccurrence {
    public static void main(String[] args) {
        _001_FirstAndLastOccurrence obj=new _001_FirstAndLastOccurrence();
        int arr[] = {5, 5, 5, 5, 5, 5};
        int k = 5;
        Arrays.stream(obj.searchRange(arr, k)).forEach(System.out::println);
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int first=findFirstAndLastPos(nums,target,true);
        if(first==-1){
            return new int[]{-1,-1};
        }
        int last=findFirstAndLastPos(nums,target,false);
        return new int[]{first,last};
    }

    public int findFirstAndLastPos(int[] nums, int target,boolean isFirst) {
        int n=nums.length;
        if(target<nums[0] || target>nums[n-1]){
            return -1;
        }

        //[5,5,5,5,5,5]
        int start=0;
        int end=n-1;
        int pos=-1;
        while(start<=end){
            int mid=(end-start)/2+start;
            if(target==nums[mid]){
                pos=mid;
                if(isFirst){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            else if(target>nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return pos;
    }


//    public static int[] searchRange(int[] nums, int target) {
//
//        int first = binarySearch(nums, target, true);
//        int last = binarySearch(nums, target, false);
//        return new int[]{first, last};
//    }
//
//    private static int binarySearch(int[] nums, int target, boolean isFirst) {
//
//        int pos = -1;
//        int low = 0;
//        int high = nums.length - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (nums[mid] == target) {
//                pos = mid;
//                if (isFirst) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
//            } else if (nums[mid] > target) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//
//        if (pos != -1) {
//            if (isFirst) {
//                pos = low;
//            } else {
//                pos = high;
//            }
//        }
//        return pos;
//    }
//
//    public static ArrayList<Long> find(long arr[], int n, int k) {
//        // code here
//        ArrayList<Long> res = new ArrayList();
//        long firstIndex = findIndex(arr, k, true);
//        long lastIndex = findIndex(arr, k, false);
//        res.add(firstIndex);
//        res.add(lastIndex);
//        return res;
//
//    }
//
//
//    public static long findIndex(long arr[], int k, boolean firstOccurrence) {
//        long start = 0;
//        long end = arr.length - 1;
//        long ans = -1;
//        while (start <= end) {
//            int mid = (int) ((int) (end - start) / 2 + start);
//            if (arr[mid] == k) {
//                //first and last occurrrence
//                ans = mid;
//                if (firstOccurrence) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            } else if (arr[mid] > k) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return ans;
//    }
}

package com.leetcode.searchandsort;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class _003_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(searchOnePass(nums, target));
    }

    public static int searchOnePass(int[] arr, int target) {

        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(high+low) >> 1;
            if(arr[mid]==target){
                return mid;
            }
            //left array is sorted
            if(arr[low]<=arr[mid]){
                if(target>=arr[low] && target<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
                //right
            }else{
                if(target>=arr[mid] && target<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    /**
     * 2 pass algo
     */
    public static int search(int[] nums, int target) {
        int pIndex = pivotIndex(nums);
        if (nums[0] <= target && (pIndex!=0 && nums[pIndex-1]>=target)) {
            return binarySearch(nums, target, 0, pIndex - 1);
        } else if (nums[pIndex] <= target && target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, pIndex, nums.length - 1);
        }
        return -1;
    }


    public static int pivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (arr[mid] >= arr[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }


    public static int binarySearch(int[] arr, int target, int s, int e) {
        int start = s;
        int end = e;
        int ans = -1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (arr[mid] == target) {
                ans = mid;
                break;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}

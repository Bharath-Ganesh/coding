package com.practice.uiuc.array;

//Remove Duplicates from Sorted Array II
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();
        int[] nums = { 0,0,1,1,1,1,2,3,3 };
        System.out.println(obj.removeDuplicates(nums));
        System.out.println();
    }

    public int removeDuplicates(int[] nums) {

        // 1,1,1,2,2,3
        // 1,1,1,2,2,3
        int n = nums.length;

        int left = 0;
        int right = 0;
        while(right < n ){
            int farthest = 0;
            for(int i = right; i < n - 1; i++){
                farthest = i;
                if(nums[i] != nums[i+1]){
                    break;
                }

            }

            int max = Math.min((farthest - right) + 1, 2);
            int index;
            for(index = left; index < max; index++){
                nums[left] = nums [right];
            }
            left = index;
            right = farthest + 1;
        }
        return left;
    }

}

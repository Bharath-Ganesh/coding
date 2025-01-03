package com.practice.uiuc.bits;

public class FindDuplicateNumber {

    public static void main(String[] args) {
        FindDuplicateNumber obj = new FindDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        System.out.println(obj.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {

        int duplicate = 0;
        // [0,1,2,3,4]
        // [1,3,4,2,2]
        // [1,-3,-4,-2,-2]

        /*
            MODIFYING INPUT ARRAY
        */
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]);
            if(nums[index] < 0){
                return Math.abs(nums[i]);
            }else{
                nums[index] = nums[index] * -1;
            }
        }
        return -1;
    }
}

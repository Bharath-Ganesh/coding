package com.practice.uiuc.array;

public class MinJumps {

    public static void main(String[] args) {
        MinJumps obj = new MinJumps();
        int[] arr = {1,2,3};
        obj.jump(arr);
    }

    public int jump(int[] nums) {

        int n = nums.length;

        int left = 0;
        int right = 0;
        int jumps = 0;
        while(right < n - 1){
            int farthest = 0;
            for(int i = left; i <= right; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            jumps += 1;
            left = right + 1;
            right = farthest;
        }
        return jumps;
    }
}

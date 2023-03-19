package com.leetcode.stackqueues;

import java.util.Arrays;
import java.util.Stack;

/**
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 */
public class _004_NextGreaterElement2 {

    public static void main(String[] args) {
        int[] nums={1,3,5,8,2,7,6,12,4};
       // System.out.println(Arrays.toString(nextGreaterElementsSecond(nums)));
       System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*n-1;i>=0;i--) {
            int index=i%n;
            int element=nums[index];
            while(st.isEmpty() == false && st.peek() <= element) {
                st.pop();
            }

            if(i<n) {
                if(st.isEmpty() == false) nge[i] = st.peek();
                else nge[i] = -1;
            }

            st.push(element);
        }
        return nge;
    }

    public static  int[] nextGreaterElementsSecond(int[] nums) {
        Stack<Integer> stack=new Stack();
        int n=nums.length;
        int[] nge=new int[nums.length];
        Arrays.fill(nge,-1);
        for(int i=0;i<2*n;i++){
            int index=i%n;
            while(!stack.isEmpty() && nums[index] > nums[stack.peek()]){
                nge[stack.pop()]=nums[index];
            }
            if(i<n){
                stack.push(i);
            }
        }
        return nge;
    }
}

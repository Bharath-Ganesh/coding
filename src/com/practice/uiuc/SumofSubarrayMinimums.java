package com.practice.uiuc;

import java.util.Stack;

public class SumofSubarrayMinimums {

    public static void main(String[] args) {
        SumofSubarrayMinimums obj = new SumofSubarrayMinimums();
        int[] arr = {11,81,94,43,3};
        System.out.println(obj.sumSubarrayMins(arr));
    }

    public int sumSubarrayMins(int[] arr) {

        int[] rightArr = nextSmallerElementToRight(arr);
        int[] leftArr = nextSmallerElementOrEqualToLeft(arr);
        int modulus = (int) (Math.pow(10, 9) + 7);
        int contribution = 0;
        for(int i=0; i<arr.length; i++){

            int left = i -leftArr[i];
            int right = rightArr[i] - i;
            int currContribution = ((left * right * arr[i]) % modulus);
            contribution =  (contribution + currContribution) % modulus;
        }
        return (int) contribution;
    }


    private int[] nextSmallerElementToRight(int[] nums) {

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for(int index= n - 1; index >=0; index--){

            while(!stack.isEmpty() && nums[stack.peek()] >= nums[index]){
                stack.pop();
            }
            result[index] = stack.isEmpty()? n :stack.peek();
            stack.push(index);
        }
        return result;
    }


    public int[] nextSmallerElementOrEqualToLeft(int[] nums) {

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[n];

        for(int index= 0; index <n; index++){

            while(!stack.isEmpty() && nums[stack.peek()] > nums[index]){
                stack.pop();
            }
            result[index] = stack.isEmpty()? -1 :stack.peek();
            stack.push(index);
        }
        return result;
    }
}

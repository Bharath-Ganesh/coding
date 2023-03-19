package com.practice.pepcoding.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * int[] arr = { 2, 3, 5, 9, 1, 12, 6, 8, 7 };
 * 
 * int[] output={3,5,9,12,12, -1,8,-1,-1}
 * 
 */
/*
 * Greater element to 2 is 3 Greater element to 3 is 5 Greater element to 5 is 9
 * Greater element to 9 is 12 Greater element to 1 is 12 Greater element to 12
 * is -1 Greater element to 6 is 8 Greater element to 8 is -1 Greater element to
 * 7 is -1 Complexity O(n)
 * 
 */

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 9, 1, 12, 6, 8, 7 };
		// int[] output={3,5,9,12,12, -1,8,-1,-1}

		int[] greaterElementArray = nextGreaterElementRightToLeftApproach(arr);
		System.out.println(Arrays.toString(greaterElementArray));
	}


	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		Stack<Integer> stack=new Stack();
		int[] nge=new int[nums2.length];
		nge[nums2.length-1]=-1;
		for(int i=nums2.length-2;i>=0;i--){
			int num=nums2[i];
			while(!stack.empty() && stack.peek()<num){
				stack.pop();
			}
			nge[i]=stack.empty()?-1:stack.peek();
		}

		int[] res=new int[nums1.length];
		for(int i=0;i<nums1.length;i++){
			for(int j=0;j<nums2.length;j++){
				if(nums1[i]==nums2[j]){
					res[i]=nge[j];
					break;
				}
			}
		}
		return res;
	}

	private static int[] nextGreaterElementRightToLeftApproach(int[] arr) {

		Stack<Integer> stack = new Stack<>();
		int[] greaterElementArray = new int[arr.length];
		stack.push(arr.length - 1);
		greaterElementArray[arr.length - 1] = -1;

		for (int i = arr.length - 2; i >= 0; i--) {

			while (stack.size() > 0 && arr[i] >= arr[stack.peek()]) {
				stack.pop();
			}
			if (stack.size() == 0) {
				greaterElementArray[i] = -1;
			} else {
				greaterElementArray[i] = arr[stack.peek()];
			}
			stack.push(i);
		}
		return greaterElementArray;

	}

	private static int[] nextGreaterElementLeftToRightApproach(int[] arr) {

		Stack<Integer> stack = new Stack<>();
		int[] greaterElementArray = new int[arr.length];
		stack.push(0);
// int[] arr = { 2, 3, 5, 9, 1, 12, 6, 8, 7 };
		for (int i = 1; i < arr.length; i++) {
			while (stack.size() > 0 && arr[i] >= arr[stack.peek()]) {
				int pos = stack.peek();
				greaterElementArray[pos] = arr[i];
				stack.pop();
			}
			stack.push(i);

		}
		while (stack.size() > 0) {
			int pos = stack.peek();
			greaterElementArray[pos] = -1;
			stack.pop();
		}
		return greaterElementArray;

	}
}
package com.practice.pepcoding.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Consider a histogram where each element of the array represents a rectangle
 * of unit width and the given height element -> 6*1->6 find max area.
 *
 */
public class FindMaxAreaOfRectangleInAHistogram {

	public static void main(String[] args) {
		            // 0, 1, 2, 3, 4, 5, 6 }
		   int[] arr={ 6, 2, 5, 4, 5, 1, 6 };
		// int[] lse={ -1,-1,1, 1, 3, -1, 5};  
		// int[] rse={ 1, 5, 3, 5, 5, 7, 7};
		int area = maxAreaOfRectangleInAHistogram(arr);
		System.out.println(area);

	}

	private static int maxAreaOfRectangleInAHistogram(int[] arr) {

	
		int[] rse = new int[arr.length];
		int max_area=-1;
		Stack<Integer> stack = new Stack<>();
		stack.push(arr.length-1);
		rse[arr.length-1]=arr.length;
		for (int i = arr.length-2; i>= 0; i--) {
			while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
				stack.pop();
			}
			
			if(stack.size()==0) {
				rse[i]=arr.length;
			}else {
				rse[i]=stack.peek();
			}
			stack.push(i);
		}
		
		int[] lse = new int[arr.length];
		stack=new Stack<>();
		stack.push(0);
		lse[0]=-1;
		
		for (int i = 1; i< arr.length; i++) {
			while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
				stack.pop();
			}
			
			if(stack.size()==0) {
				lse[i]=-1;
			}else {
				lse[i]=stack.peek();
			}
			stack.push(i);
		}
		
		for (int i = 0; i < arr.length; i++) {
			int width=rse[i]-lse[i]-1;
			int area=arr[i]*width;
			if(area>max_area) {
				max_area=area;
			}
		}
		return max_area;
	}

}

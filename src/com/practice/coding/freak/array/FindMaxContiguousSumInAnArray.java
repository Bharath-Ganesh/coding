package com.practice.coding.freak.array;

/**
 * Given an array. Fin the max contiguous  sum
 *int[] arr = { -2, -3, 4, -1, 2, 1, 5, -3 };
 *
 */
public class FindMaxContiguousSumInAnArray {

	public static void main(String args[]) {

		int[] arr = { -2, -3, 4, -1, 2, 1, 5, -3 };
		int max_sum=0;
		int max_so_far=0;
		
		for (int i = 0; i < arr.length; i++) {
			max_sum+=arr[i];
			if(max_sum<0) {
				max_sum=0;
			}else {
				if(max_sum>max_so_far) {
					max_so_far=max_sum;
				}
			}
		}
		System.out.println(max_so_far);

	}

}

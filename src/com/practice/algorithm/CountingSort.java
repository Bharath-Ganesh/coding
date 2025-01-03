package com.practice.algorithm;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		// 0, 0, 2, 2, 3, 3, 3, 5
		int[] arr = {0, 0, 2, 2, 3, 3, 3, 5 };
		int[] result = countingSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(result));
	}

	private static int[] countingSort(int[] arr) {

		// to store the sorted array
		int result[] = new int[arr.length];

		// the maximum element in th array is 5
		int maxElement=-1;
		for(int i=0;i<arr.length;i++){
			maxElement=Math.max(maxElement,arr[i]);
		}
		int[] cumulativeArr = new int[maxElement+1];

		// result = [2,0,2,3,0,1]
		for (int i = 0; i < arr.length; i++)
			cumulativeArr[arr[i]]++;

		// [2,2,4,7,7,8]
		for (int i = 1; i < cumulativeArr.length; i++)
			cumulativeArr[i] += cumulativeArr[i - 1];


		for (int i = arr.length - 1; i >= 0; i--) {
			//result[c[3]]
			result[cumulativeArr[arr[i]] - 1] = arr[i];
			cumulativeArr[arr[i]] -= 1;
		}


		return result;
	}

}

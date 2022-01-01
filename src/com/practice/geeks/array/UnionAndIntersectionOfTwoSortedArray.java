package com.practice.geeks.array;

import java.util.Arrays;

/**
 * Given two sorted arrays, find their union and intersection.
 * 
 * Input : arr1[] = {1, 3, 4, 5, 7} arr2[] = {2, 3, 5, 6}
 * 
 * Output : Union : {1, 2, 3, 4, 5, 6, 7}
 * 
 * Intersection : {3, 5}
 */
public class UnionAndIntersectionOfTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 4, 5, 7, 8, 9 };
		int[] arr2 = { 2, 3, 5, 6 };
		int[] union = findUnion(arr1, arr2);
		int[] intersection = findIntersection(arr1, arr2);
		System.out.println(Arrays.toString(union));
		System.out.println(Arrays.toString(intersection));
	}

	public static int[] findUnion(int[] arr1, int[] arr2) {
		int[] union = new int[arr1.length + arr2.length];

		int i = 0;
		int j = 0;
		int counter = 0;
		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] > arr2[j]) {
				union[counter] = arr2[j];
				j++;
			} else if (arr1[i] < arr2[j]) {
				union[counter] = arr1[i];
				i++;
			} else {
				union[counter] = arr1[i];
				i++;
				j++;
			}

			counter++;
		}

		while (i < arr1.length) {
			union[counter++] = arr1[i++];
		}
		while (j < arr2.length) {
			union[counter++] = arr2[j++];
		}
		return union;
	}

	public static int[] findIntersection(int[] arr1, int[] arr2) {
		int[] intersection = new int[arr1.length];
		int sizeOfArray1 = arr1.length;
		int sizeOfArray2 = arr2.length;

		int i = 0, j = 0;
		int count = 0;
		while (i != sizeOfArray1 && j != sizeOfArray2) {

			if (arr1[i] > arr2[j]) {

				j++;
			} else if (arr1[i] < arr2[j]) {

				i++;
			} else {
				intersection[count++] = arr1[i];
				i++;
				j++;
			}
		}

		return intersection;
	}

}

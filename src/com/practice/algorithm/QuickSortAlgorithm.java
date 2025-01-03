package com.practice.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Quick sort algorithm
 *
 */
public class QuickSortAlgorithm {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 8, 10, 16, 18, 5 };
		int start = 0;
		int end = arr.length - 1;
		quickSort(arr, start, end);
		System.out.println(Arrays.toString(arr));

		fairRations(Arrays.asList(1, 2));
	}

	private static void quickSort(int[] arr, int start, int end) {
		if(start<end){
			int partitionIndex = randomizedPartition(arr, start, end);
			quickSort(arr, start, partitionIndex-1);
			quickSort(arr, partitionIndex+1, end);
		}
	}

	private static int randomizedPartition(int[] arr, int start, int end) {
		Random random = new Random();
		// Print next int value
		// Returns number between end-start
		int randomIndex = random.nextInt((end - start)+ 1);
		System.out.println("Random number:" + random.nextInt(end - start) + " Start:" + start + " End:" + end + " Diff: " + (end-start));
		swap(arr, start + randomIndex, end);
		int partitionIndex = findPartitionIndex(arr, start, end);
		return partitionIndex;
	}

	private static int findPartitionIndex(int[] arr, int start, int end) {
		int pivotElement = arr[end];
		int partitionIndex= start;
		for(int i=start;i<end;i++){
			if(arr[i] < pivotElement){
				swap(arr,i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(arr,end, partitionIndex);
		return partitionIndex;
	}

	//	private static void quickSort(int[] arr, int start, int end) {
//		if (start >= end) {
//			return;
//		}
//		int partitionIndex = randomizedPartition(arr, start, end);
//		quickSort(arr, start, partitionIndex - 1);
//		quickSort(arr, partitionIndex + 1, end);
//
//	}
//
//	public static int partition(int[] arr, int start, int end) {
//
//		int pivot = arr[end];
//		int partitionIndex = start;
//		for (int i = start; i < end; i++) {
//			if (arr[i] < pivot) {
//				swap(arr, partitionIndex, i);
//				partitionIndex++;
//			}
//		}
//		swap(arr, partitionIndex, end);
//
//		return partitionIndex;
//	}
//
//	public static int randomizedPartition(int[] arr, int start, int end) {
//
//		Random rand = new Random();
//		int pivotIndex = start + rand.nextInt(end - start + 1);
//		swap(arr, pivotIndex, end);
//		int partitionIndex = partition(arr, start, end);
//		return partitionIndex;
//	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static String fairRations(List<Integer> arr) {

		// 2 3 4 5 6
		int count = 0;
		for (int i = 0; i < arr.size() - 1; i++) {

			if (arr.get(i) % 2 != 0) {
				arr.set(i, arr.get(i) + 1);
				arr.set(i + 1, arr.get(i + 1) + 1);
				count += 2;
			}
		}
		int n = arr.size() - 1;
		if ((arr.get(n) % 2 != 0) && (arr.get(n - 1) % 2 == 0)) {
			return "NO";
		}
		return count + "";

	}

}

package com.practice.hacerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a number of sticks of varying lengths. You will iteratively cut
 * the sticks into smaller sticks, discarding the shortest pieces until there
 * are none left. At each iteration you will determine the length of the
 * shortest stick remaining, cut that length from each of the longer sticks and
 * then discard all the pieces of that shortest length. When all the remaining
 * sticks are the same length, they cannot be shortened so discard them.
 * 
 * Given the lengths of sticks, print the number of sticks that are left before
 * each iteration until there are none left.
 * 
 * 
 */
//input  : 5 4 4 2 2 8 
//sticks-length        length-of-cut   sticks-cut
//5 4 4 2 2 8             2               6
//3 2 2 _ _ 6             2               4
//1 _ _ _ _ 4             1               2
//_ _ _ _ _ 3             3               1
// _ _ _ _ _           DONE            DONE

// output : 6,4,2,1
public class CutTheStick {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(141, 106, 156, 260, 860, 255, 449, 662, 428, 728, 136, 422,
				534, 899, 233, 681, 198, 190, 447, 553, 202, 65, 339, 369, 599, 850, 428, 984, 129, 113, 644, 195, 616,
				950, 250, 489, 86, 552, 694, 309, 593, 694, 361, 505, 970, 752, 344, 53, 548, 986, 976, 331, 469, 544,
				75, 917, 328, 734, 337, 48, 689, 443, 33, 781, 270, 90, 471, 121, 514, 220, 908, 80, 105, 888, 504, 106,
				813, 496, 127, 810, 851, 74, 23, 51, 60, 216, 900, 856, 958, 444, 750, 330, 461, 475, 896, 572, 266,
				271, 461, 755, 171, 471, 358, 462, 566, 29, 874, 458, 535, 191, 582, 408, 521, 40, 290, 642, 511, 140,
				56, 645, 422, 21, 312, 625, 512, 261, 457, 847, 601, 591, 923, 119, 340, 487, 731, 555, 241, 956, 59,
				883, 783, 795, 479, 758, 884, 203, 953, 535, 530, 802, 870, 965, 514, 465, 938, 53, 516, 894, 527, 258,
				6, 661, 631, 412, 613, 556, 523, 522, 621, 992, 714, 458, 921, 919, 7, 152, 60, 904, 179, 720, 345, 62,
				282, 133, 260, 830, 831, 581, 12, 608, 672, 50, 195, 309, 601, 527, 875, 102, 103, 4, 115, 444, 570,
				681, 799, 224, 388, 439, 413, 719, 695, 954, 203, 607, 380, 513, 619, 960, 236, 156, 367, 711, 528, 752,
				166, 473, 744, 143, 215, 783, 402, 17, 497, 854, 382, 159, 513, 799, 145, 167, 518, 527, 143, 396, 167,
				583, 566, 386, 786, 965, 182, 662, 41, 422, 893, 852, 198, 761, 417, 670, 899, 748, 845, 342, 344, 504,
				411, 513, 231));

		List<Integer> cutTheSticksCountSort = cutTheSticksCountSort(arr);
		System.out.println(cutTheSticksCountSort);

		List<Integer> cutTheSticks = cutTheSticks(arr);
		System.out.println(cutTheSticks);

	}

	/**
	 * 0(n2)
	 */
	public static List<Integer> cutTheSticks(List<Integer> arr) {
		List<Integer> result = new ArrayList<>();
		insertionSortArray(arr);
		int min = 0;
		int min_index = 0;
		while (true) {
			for (int i = min_index; i < arr.size(); i++) {
				if (arr.get(i) != 0) {
					min = arr.get(i);
					min_index = i;
					break;
				}
			}

			if (min_index + 1 == arr.size()) {
				result.add(arr.size() - min_index);
				break;
			}

			for (int i = min_index; i < arr.size(); i++) {
				int diff = arr.get(i) - min;
				arr.set(i, diff);
			}
			result.add(arr.size() - min_index);
		}

		return result;

	}

	public static void insertionSortArray(List<Integer> arr) {
		for (int i = 1; i < arr.size(); i++) {

			int hole = i;
			int pivot = arr.get(hole);
			while (hole > 0 && arr.get(hole - 1) > pivot) {
				arr.set(hole, arr.get(hole - 1));
				hole--;
			}
			arr.set(hole, pivot);
		}
	}

	/*
	 * O(n)
	 */
	public static List<Integer> cutTheSticksCountSort(List<Integer> arr) {
		List<Integer> result = new ArrayList<>();
		int count[] = new int[1001];

		// frequency of elements
		for (int i = 0; i < arr.size(); i++)
			count[arr.get(i)]++;

		int n = arr.size();
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				result.add(n);
				n -= count[i];
			}
		}
		return result;

	}

}

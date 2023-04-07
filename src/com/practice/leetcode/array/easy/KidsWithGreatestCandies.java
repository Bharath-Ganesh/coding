package com.practice.leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given the array candies and the integer extraCandies, where candies[i]
 * represents the number of candies that the ith kid has.
 * 
 * For each kid check if there is a way to distribute extraCandies among the
 * kids such that he or she can have the greatest number of candies among them.
 * Notice that multiple kids can have the greatest number of candies.
 * 
 * Input: candies = [4,2,1,1,2], extraCandies = 1 Output:
 * [true,false,false,false,false] Explanation: There is only 1 extra candy,
 * therefore only kid 1 will have the greatest number of candies among the kids
 * regardless of who takes the extra candy.
 *
 */
public class KidsWithGreatestCandies {

	public static void main(String args[]) {
		int[] candies = { 2, 3, 5, 1, 3 };
		int extraCandies = 3;
		List<Boolean> candiesBoolean = kidsWithCandies(candies, extraCandies);
		System.out.println(candiesBoolean.toString());

	}

	public static List<Boolean> kidsWithCandiesLeetCode(int[] candies, int extraCandies) {

		int maxCandies = Arrays.stream(candies).max().getAsInt();
		return Arrays.stream(candies).mapToObj(candy ->  candy+extraCandies >= maxCandies).collect(Collectors.toList());
		
		

	}

	/**
	 * My solution
	 */
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

		List<Boolean> candiesBoolean = new ArrayList<>();
		// To find the maximum
		// max = Math.max(max, candies[i]);

		int maxCandies = Arrays.stream(candies).max().getAsInt();
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= maxCandies) {
				candiesBoolean.add(true);
			} else {
				candiesBoolean.add(false);
			}
		}

		return candiesBoolean;

	}

}

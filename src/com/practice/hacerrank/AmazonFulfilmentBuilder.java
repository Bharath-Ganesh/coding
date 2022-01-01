package com.practice.hacerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Input  : 20, 4, 8, 2
 * Output : 6,8,20 -> 14,20 -> 34
 *          6+14+34 -> 54
 *          
 * Input  : 8, 4, 6, 12
 * Output : 58
 *         
 */
public class AmazonFulfilmentBuilder {

	public static void main(String[] args) {
		List<Integer> parts = new ArrayList<>(Arrays.asList(8, 4, 6, 12));
		int minimumtime = combineParts(parts);
		System.out.println(minimumtime);

	}

	public static int combineParts(List<Integer> parts) {
		int minimumTime = 0;
		int numberOfItems = parts.size();

		if (numberOfItems == 1) {
			minimumTime = parts.get(0);
		} else if (numberOfItems == 2) {
			minimumTime = parts.get(0) + parts.get(1);
		} else {
			parts = parts.stream().sorted().collect(Collectors.toList());
			int mergingToBeCompleted = 1;
			while (true) {
				int mergeTime = parts.get(0) + parts.get(1);
				minimumTime += mergeTime;
				parts.remove(0);
				parts.remove(0);

				if (mergingToBeCompleted == numberOfItems - 1) {
					break;
				}

				if (parts.get(0) >= mergeTime) {
					parts.add(0, mergeTime);
				} else if (parts.get(parts.size() - 1) <= mergeTime) {
					parts.add(mergeTime);
				} else {
					for (int i = 0; i < parts.size() - 1; i++) {
						if (parts.get(i) < mergeTime && parts.get(i + 1) > mergeTime) {
							parts.add(i + 1, mergeTime);
							break;
						}
					}
				}
				mergingToBeCompleted++;

			}
		}

		return minimumTime;

	}

}

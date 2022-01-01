package com.practice.hacerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManasaAndStone {

	public static void main(String[] args) {

//		List<Integer> stones = new ArrayList<>();
//		stones(4, 10, 100, 0, stones);
//		stones.stream().forEach(x -> System.out.printf("%d ", x));
		List<Integer> stones = stonesUsingHashSet(5, 3, 23);
		stones.stream().sorted((num1, num2) -> num1 > num2 ? 1 : -1).forEach(x -> System.out.printf("%d ", x));

	}

//n=4				         0
//			     		/		  \
//n=3			    10       		100
//		 		 /    \     	  /     \
//n=2			20       110 	 110     200
//	  			/  \     /	\    /  \    /  \
//n=1		30	  120 120  210  120 210 210  300 
	public static void stones(int n, int a, int b, int stoneValue, List<Integer> stones) {

		if (n == 1) {
			if (!stones.contains(stoneValue)) {
				stones.add(stoneValue);
			}
			return;
		}
		stones(n - 1, a, b, stoneValue + a, stones);
		stones(n - 1, a, b, stoneValue + b, stones);

	}

	public static List<Integer> stonesUsingHashSet(int n, int a, int b) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int sum = i * b + (n - (i + 1)) * a;
			result.add(sum);
		}
		// Collections.sort(result, Collections.reverseOrder());
		// Collections.reverseOrder() => this is a Comparator
//		Collections.sort(result, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
		return result.stream().sorted((num1, num2) -> num1 > num2 ? 1 : -1).distinct().collect(Collectors.toList());

	}

}

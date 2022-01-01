package com.practice.hacerrank;

public class KaprekarNumber {

	public static void main(String[] args) {
		kaprekarNumbers(1, 99999);

	}

	public static void kaprekarNumbers(int p, int q) {

		String left = "";
		String right = "";
		boolean flag = false;
		for (int i = p; i <= q; i++) {
			String num = i + "";
			long squared = (long) i * i;
			String sqaure = squared + "";
			int digitLength = num.length();
			int sqaureLength = sqaure.length();
			int leftLength = sqaure.length() == (digitLength * 2) ? sqaureLength / 2 : digitLength - 1;
			int rightLength = sqaure.length() == (digitLength * 2) ? sqaureLength / 2 : digitLength - 1;
		
			
			if (i == 1) {
				System.out.printf("%d ", i);
				flag = true;
			} else if (i > 3) {
				left = sqaure.substring(0, leftLength);
				right = sqaure.substring(rightLength);
				int sum = Integer.parseInt(left) + Integer.parseInt(right);
				if (sum == i) {
					System.out.printf("%d ", i);
					flag = true;
				}

			}

		}
		if (!flag)
			System.out.println("INVALID RANGE");
	}

}

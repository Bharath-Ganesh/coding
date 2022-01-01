package com.practice.pepcoding.string;

/**
 * Given a string. Input="aaabbbccdeef" CompressionOne => Output=a3b3c2de2f
 * CompressionTwo => Output=abcdef
 */
public class StringCompression {

	public static void main(String[] args) {
		String inputString = "ffffffffffffffff";
		System.out.println(stringCompressionOne(inputString));

	}
	/**
	 * 
	 * @param inputString
	 * @return
	 */
	public static String stringCompressionOne(String inputString) {

		String newString = inputString.substring(0, 1);
		int count = 1;
		for (int i = 0; i < inputString.length() - 1; i++) {
			Character prevChar = inputString.charAt(i);
			Character currChar = inputString.charAt(i + 1);
			if (prevChar.equals(currChar)) {
				count += 1;
			} else {
				if (count > 1) {
					newString += count;
					count = 1;

				}
				newString += currChar;

			}
		}

		if (count > 1) {
			newString += count;
		}

		return newString;
	}

	public static String stringCompressionTwo(String inputString) {

		String newString = inputString.substring(0, 1);
		for (int i = 0; i < inputString.length() - 1; i++) {
			Character prevChar = inputString.charAt(i);
			Character currChar = inputString.charAt(i + 1);
			if (prevChar.equals(currChar)) {
				continue;
			} else {
				newString += currChar;

			}
		}

		return newString;
	}

}

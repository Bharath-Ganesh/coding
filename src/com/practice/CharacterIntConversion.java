package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In this challenge, you will be given a list of letter heights in the alphabet
 * and a string. Using the letter heights given, determine the area of the
 * rectangle highlight in assuming all letters are wide.
 * 
 * For example, the highlighted . Assume the heights of the letters are and .
 * The tallest letter is high and there are letters. The hightlighted area will
 * be so the answer is .
 * 
 * 
 * Input : 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 7
 * 
 * word : zaba output : 28 : Max(input) * length of the word
 *
 */
public class CharacterIntConversion {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(
				Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7));
		Integer area = designerPdfViewerWithoutMap(numbers, "zaba");
		System.out.println(area);
	}

	private static Integer designerPdfViewerWithoutMap(List<Integer> numbers, String word) {

		Integer area = 0;
		int maxHeight = 0;
		for (int i = 0; i < word.length(); i++) {
			int charValue = word.charAt(i);

			// The height of the variable would be the ASCII value of current char is ASCII
			// of a(97)
			int height = numbers.get(charValue - 97);
			if (height > maxHeight) {
				maxHeight = height;
			}

		}
		area = maxHeight * word.length();
		return area;
	}

}

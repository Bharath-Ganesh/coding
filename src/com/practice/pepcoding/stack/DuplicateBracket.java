package com.practice.pepcoding.stack;

import java.util.Stack;

/*
 * You are given an expression , but some of the pairs of bracket are extra or needless
 * You are required to print true if you detect extra brackets and false otherwise
 * 
 *  ((a+b) + (e+f)) -> false 
 *   a+b +  ((e+f))   -> true
 */
public class DuplicateBracket {

	public static void main(String args[]) {
		String inputString = "((a+b) + (e+f))";
		System.out.println(dupliclateBracket(inputString));
	}

	/**
	 * 
	 */
	public static boolean dupliclateBracket(String inputString) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);
			if (ch == ')') {
				if (stack.peek() == '(') {
					return true;
				} else {
					while (!stack.isEmpty() && stack.peek() != '(') {
						stack.pop();
					}
					stack.pop();
				}
			} else {
				stack.push(inputString.charAt(i));
			}
		}
		return false;
	}

}

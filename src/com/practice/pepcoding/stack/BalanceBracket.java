package com.practice.pepcoding.stack;

import java.util.Stack;

/*
 * You are given an expression , but some of the pairs of bracket are extra or needless
 * You are required to print true if you detect extra brackets and false otherwise
 * 
 * input = "[(a+b) + {(c+d) * (e/f)}]"; -> true
 * input = "[[[(a+b) + {(c+d) * (e/f)}]"; -> false
 *  
 */

public class BalanceBracket {

	public static void main(String[] args) {
		String input = "[(a+b)+{(c+d)*(e/f)}]";
		if (balanceBracket(input)) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not balanced");
		}
	}

	private static boolean balanceBracket(String input) {
		Stack<Character> characterStack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			Character ch = input.charAt(i);
			if (ch == '{' || ch == '[' || ch == '(') {
				characterStack.push(ch);
			} else if (ch == '}') {
				if (!checkLastCharacterAreSame(characterStack, '{')) {
					return false;
				}
			} else if (ch == ')') {
				if (!checkLastCharacterAreSame(characterStack, '(')) {
					return false;
				}
			} else if (ch == ']') {

				if (!checkLastCharacterAreSame(characterStack, '[')) {
					return false;
				}
			} else {
				continue;
			}
		}
		return true;
	}

	/**
	 * @param characterStack
	 */
	public static boolean checkLastCharacterAreSame(Stack<Character> characterStack, Character symbol) {
		if (characterStack.peek() != symbol) {
			return false;
		} else {
			if (characterStack.size() != 0) {
				characterStack.pop();
			} else {
				return false;
			}

		}
		return true;
	}

}

package com.practice.mycodeschool.ds;

import java.util.Stack;

/*
 * You are given an expression , but some of the pairs of bracket are extra or needless
 * You are required to print true if you detect extra brackets and false otherwise
 * 
 * input = "[(a+b) + {(c+d) * (e/f)}]"; -> true
 * input = "[[[(a+b) + {(c+d) * (e/f)}]"; -> false
 *  
 */
public class BalancedBracketParenthesis {

	public static void main(String[] args) {
		String input = "[(])";
		System.out.println(balancedBracketParenthesis(input));
		System.out.println(checkParanthesesBalanced(input));
	}

	private static boolean balancedBracketParenthesis(String input) {

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (ch == ')') {
				if (!st.isEmpty()) {
					if (st.peek() != '(') {
						return false;
					}
					st.pop();
				}
			} else if (ch == '}') {
				if (!st.isEmpty()) {
					if (st.peek() != '}') {
						return false;
					}
					st.pop();
				}
			} else if (ch == ']') {
				if (!st.isEmpty()) {
					if (st.peek() != '[') {
						return false;
					}
					st.pop();
				}
			}
		}

		if (!st.isEmpty())
			return false;
		return true;
	}

	public static boolean arePair(char opening, char closing) {
		if (opening == '(' && closing == ')')
			return true;
		else if (opening == '{' && closing == '}')
			return true;
		else if (opening == '[' && closing == ']')
			return true;
		return false;
	}

	public static boolean checkParanthesesBalanced(String exp) {
		Stack<Character> S = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '[')
				S.push(exp.charAt(i));
			else if (exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']') {
				if (S.empty() || !arePair(S.peek(), exp.charAt(i)))
					return false;
				else
					S.pop();
			}
		}
		return S.empty() ? true : false;
	}

}

package com.practice.pepcoding.stack;

import java.util.Stack;

// Evaluate the expression -> 2 + (5 - 3 * 6/2)
// output = -2;
public class InfixEvaluation {

	public static void main(String args[]) {
		String expression = "2 + 5 * 2";
		// String expression = "5 + 3 * 2 - 9 + (2 + 5 * 3 - 2) ";
		// String expression = "2 + (5 - 3 *6 / 2) ";
		Stack<Character> operators = new Stack<>();
		Stack<Integer> operands = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(') {
				operators.push(ch);
			} else if (ch == ')') {
				while (operators.size() > 0 && operators.peek() != '(') {
					int number1 = operands.pop();
					int number2 = operands.pop();
					int result = operation(number2, number1, operators.peek());
					operands.push(result);
					operators.pop();
				}
				operators.pop();
			}
			// three ways to convert char into digit
			else if (Character.isDigit(ch)) {
				// int number = Character.getNumericValue(ch);
				// int number=ch-'0';
				Integer number = Integer.parseInt(String.valueOf(ch));
				operands.push(number);
			} else if (ch == '/' || ch == '+' || ch == '*' || ch == '-') {
				while (operators.size() > 0 && operators.peek() != '('
						&& precedence(ch) <= precedence(operators.peek())) {
					int number1 = operands.pop();
					int number2 = operands.pop();
					int result = operation(number2, number1, operators.peek());
					operands.push(result);
					operators.pop();
				}
				operators.push(ch);
			}

		}
		while (operators.size() != 0) {
			int number1 = operands.pop();
			int number2 = operands.pop();
			int result = operation(number2, number1, operators.peek());
			operands.push(result);
			operators.pop();
		}
		System.out.println(operands.peek());

	}

	public static int operation(int number2, int number1, char operator) {
		if (operator == '+') {
			return number2 + number1;
		} else if (operator == '-') {
			return number2 - number1;
		} else if (operator == '*') {
			return number2 * number1;
		} else
			return number2 / number1;
	}

	public static int precedence(char operator) {
		if (operator == '+') {
			return 1;
		} else if (operator == '-') {
			return 1;
		} else if (operator == '*') {
			return 2;
		} else
			return 2;
	}

}

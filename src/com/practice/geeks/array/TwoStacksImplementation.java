package com.practice.geeks.array;

/**
 * Create a data structure twoStacks that represents two stacks. Implementation
 * of twoStacks should use only one array, i.e., both stacks should use the same
 * array for storing elements. Following functions must be supported by
 * twoStacks.
 * 
 * push1(int x) –> pushes x to first stack push2(int x) –> pushes x to second
 * stack
 * 
 * pop1() –> pops an element from first stack and return the popped element
 * 
 * pop2() –> pops an element from second stack and return the popped element
 * Implementation of twoStack should be space efficient.
 * 
 * @author bharath
 *
 */

class TwoStacks {
	int top1;
	int top2;
	int size;
	int[] arr;

	TwoStacks(int n) {
		size = n;
		top1 = -1;
		top2 = n;
		arr = new int[n];
	}

	public void push1(int element) {
		if (top1 < top2 - 1) {
			arr[++top1] = element;
		} else {
			System.out.println("Stack overflow");
		}
	}

	public void push2(int element) {
		if (top1 < top2 - 1) {
			arr[--top2] = element;
		} else {
			System.out.println("Stack overflow");
		}
	}

	public int pop1() {
		int element = 0;
		if (top1 >= 0) {
			element = arr[top1--];
		}
		return element;
	}

	public int pop2() {
		int element = 0;
		if (top2 <= size - 1) {
			element = arr[top2++];
		}
		return element;
	}

}

public class TwoStacksImplementation {

	/* Driver program to test twStacks class */
	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		System.out.print("Popped element from stack1 is " + " : " + ts.pop1() + "\n");
		ts.push2(40);
		System.out.print("Popped element from stack2 is " + ": " + ts.pop2() + "\n");
	}
}

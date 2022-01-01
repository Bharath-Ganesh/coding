package com.leetcode.recursion;

/**
 * https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
 * <p>
 * Tower of Hanoi is a mathematical puzzle where we have three rods and n disks.
 * The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
 * <p>
 * Only one disk can be moved at a time.
 * Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a
 * disk can only be moved if it is the uppermost disk on a stack.
 * No disk may be placed on top of a smaller disk.
 */
public class _017_TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        Character source = 'A';
        Character helper = 'B';
        Character destination = 'C';
        towerOfHanoi(n, source, helper, destination);
    }

    private static void towerOfHanoi(int n, Character source, Character helper, Character destination) {

        if (n == 0) {
            return;
        }
        towerOfHanoi(n-1,source,destination,helper);
        System.out.printf("\nMove disk %d from rod %s to rod %s",n,source,destination);
        towerOfHanoi(n-1,helper,source,destination);
    }


}

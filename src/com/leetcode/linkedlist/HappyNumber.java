package com.leetcode.linkedlist;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
            if (slow == fast) {
                if (slow == 1) {
                    return true;
                }
                break;
            }
        } while (slow != fast);
        return false;
    }


    public static int findSquare(int num) {
        int square = 0;
        while (num > 0) {
            int rem = (num % 10);
            square += (rem * rem);
            num = (num / 10);
        }
        return square;
    }
}

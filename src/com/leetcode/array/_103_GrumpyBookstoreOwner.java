package com.leetcode.array;

/**
 * 1052. Grumpy Bookstore Owner
 * There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store.
 * You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at
 * the start of the ith minute and all those customers leave after the end of that minute.
 * <p>
 * On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner
 * is grumpy during the ith minute, and is 0 otherwise.
 * <p>
 * When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
 * <p>
 * The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.
 * <p>
 * Return the maximum number of customers that can be satisfied throughout the day.
 * <p>
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * Output: 16
 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
public class _103_GrumpyBookstoreOwner {

    public static void main(String[] args) {
        int customers[] = {4,10,10};
        int grumpy[] = {1,1,0};
        int minutes = 2;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int maxSatisfied = 0;
        int satisfiedCust = 0;


        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfiedCust += customers[i];
            }
        }

        int nonGrumpyCustomers = 0;
        int maxCustForXMin = 0;

        for (int i = 0; i < minutes - 1; i++) {
            if (grumpy[i] == 0) {
                nonGrumpyCustomers += customers[i];
            }
            maxCustForXMin += customers[i];
        }

        for (int i = minutes - 1; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                nonGrumpyCustomers += customers[i];
            }
            maxCustForXMin += customers[i];
            maxSatisfied = Math.max(maxCustForXMin - nonGrumpyCustomers + satisfiedCust, maxSatisfied);

            if (grumpy[i - minutes + 1] == 0) {
                nonGrumpyCustomers -= customers[i - minutes + 1];
            }
            maxCustForXMin -= customers[i - minutes + 1];
        }


        return maxSatisfied;

    }
}

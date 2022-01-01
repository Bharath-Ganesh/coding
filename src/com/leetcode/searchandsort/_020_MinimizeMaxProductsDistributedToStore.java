package com.leetcode.searchandsort;

import java.util.Arrays;

/**
 * You are given an integer n indicating there are n specialty retail stores.
 * There are m product types of varying amounts, which are given as a 0-indexed integer array quantities, where quantities[i]
 * represents the number of products of the ith product type.
 * <p>
 * You need to distribute all products to the retail stores following these rules:
 * <p>
 * A store can only be given at most one product type but can be given any amount of it.
 * After distribution, each store will have been given some number of products (possibly 0). Let x represent the maximum
 * number of products given to any store. You want x to be as small as possible, i.e., you want to minimize the maximum number of
 * products that are given to any store.
 * Return the minimum possible x.
 * <p>
 * Input: n = 6, quantities = [11,6]
 * Output: 3
 * Explanation: One optimal way is:
 * - The 11 products of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3
 * - The 6 products of type 1 are distributed to the other two stores in these amounts: 3, 3
 * The maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.
 */
public class _020_MinimizeMaxProductsDistributedToStore {

    public static void main(String[] args) {
        int n = 6;
        int[] quantities = {11, 6};
        System.out.println(minimizedMaximum(n, quantities));
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();
        int minProd = -1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (isPossible(quantities, n, mid)) {
                minProd = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minProd;
    }

    public static boolean isPossible(int[] quantities, int n, int products) {

        int currProducts = 0;
        for (int q : quantities) {
            currProducts += q / products;
            currProducts += (q % products) == 0 ? 0 : 1;

            if (currProducts > n) {
                return false;
            }
        }
        return true;
    }
}

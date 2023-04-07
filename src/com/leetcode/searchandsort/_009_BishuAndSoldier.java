package com.leetcode.searchandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/problem/algorithm/bishu-and-soldiers-227/
 * Bishu went to fight for Coding Club. There were N soldiers with various powers.
 * There will be Q rounds to fight and in each round, Bishu's power will be varied. With power M, Bishu can kill all the soldiers
 * whose power is less than or equal to M(<=M). After each round, All the soldiers who are dead in the previous round will reborn.
 * Such that in each round there will be N soldiers to fight. As Bishu is weak in mathematics, help him to count the number of soldiers
 * that he can kill in each round and the total sum of their powers.
 * <p>
 * INPUT:
 * The first line of the input contains N, the number of soldiers.
 * The second line contains an array of N numbers denoting the power of each soldier
 * This third line contains Q, which denotes the number of rounds.
 * Q lines follow, each line having one number denoting the power of Bishu.
 * <p>
 * OUTPUT:
 * For each round, the output should be an array of two numbers. The first number should be the number of soldiers that Bishu can beat,
 * and the second number denotes the cumulative strength of all the soldiers that Bishu can beat.
 * <p>
 * CONSTRAINTS:
 * 1<=N<=10000
 * 1<=power of each soldier<=100
 * 1<=Q<=10000
 * 1<=power of bishu<=100
 * <p>
 * Sample Input
 * 7
 * 1 2 3 4 5 6 7
 * 3
 * 3
 * 10
 * 2
 * <p>
 * Sample Output
 * 3 6
 * 7 28
 * 2 3
 */
public class _009_BishuAndSoldier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] powers = new int[n];
        for (int i = 0; i < n; i++) {
            powers[i] = scanner.nextInt();
        }
        int rounds = scanner.nextInt();
        int[] bishuPow = new int[rounds];
        for (int i = 0; i < rounds; i++) {
            bishuPow[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(powers));
        System.out.println(Arrays.toString(bishuPow));
        findKillAndPow(powers, bishuPow);
    }

    private static void findKillAndPow(int[] powers,  int[] bishuPow) {
        Arrays.sort(powers);
        int[] prefixSum = new int[powers.length];
        prefixSum[0] = powers[0];
        for (int i = 1; i < powers.length; i++) {
            prefixSum[i] = powers[i] + prefixSum[i - 1];
        }
        for (int i = 0; i < bishuPow.length; i++) {
            int strength = bishuPow[i];
            int index = searchPowerIndex(powers, strength);
            if (index == 0) {
                System.out.printf("%d %d", 0 , 0);
            }else{
                System.out.printf("%d %d", index , prefixSum[index-1]);
            }
            System.out.println();
        }

    }

    private static int searchPowerIndex(int[] powers, int strength) {

        int start = 0;
        int end = powers.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (powers[mid] <= strength) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;

    }


}

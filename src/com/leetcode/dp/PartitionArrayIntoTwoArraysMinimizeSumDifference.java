package com.leetcode.dp;

import java.util.*;

public class PartitionArrayIntoTwoArraysMinimizeSumDifference {

    public static void main(String[] args) {
        PartitionArrayIntoTwoArraysMinimizeSumDifference obj = new PartitionArrayIntoTwoArraysMinimizeSumDifference();
        int[] arr = {2,-1,0,4,-2,-9};
        int i = obj.minimumDifference2(arr);
        System.out.println(i);

    }

    public int minimumDifference2(int[] nums) {
        int N = nums.length;
        int nhalf = N/2;

        int[] left = Arrays.copyOfRange(nums, 0, nhalf);
        int[] right = Arrays.copyOfRange(nums, nhalf, N);

        Map<Integer, Set<Integer>> leftSums = new HashMap<>();
        Map<Integer, Set<Integer>> rightSums = new HashMap<>();
        dfs(left, 0, 0, 0, leftSums);
        dfs(right, 0, 0, 0, rightSums);

        int ans = Math.abs(sum(left) - sum(right));
        int total = sum(nums);
        int half = total / 2;

        for (int k = 1; k < nhalf; k++) {
            Set<Integer> leftSet = leftSums.get(k);
            Set<Integer> rightSet = rightSums.get(nhalf-k);

            int[] rightSorted = new int[rightSet.size()];
            int i = 0;
            for (Integer r: rightSet) rightSorted[i++] = r;
            Arrays.sort(rightSorted);

            for (Integer x: leftSet) {
                int remain = half - x;
                int idx2 = binarySearchLeft(rightSorted, remain);

                for (int q = 0; q < 2; q++) {
                    if (0 <= idx2-q && idx2-q < rightSorted.length) {
                        int leftAnsSum = x + rightSorted[idx2-q];
                        int rightAnsSum = total - leftAnsSum;
                        int diff = Math.abs(leftAnsSum - rightAnsSum);
                        ans = Math.min(ans, diff);
                    }
                }
            }
        }
        return ans;
    }

    public static void dfs(int[] nums, int i, int currSum, int elemCount, Map<Integer, Set<Integer>> kSums) {
        if (i == nums.length) {
            kSums.putIfAbsent(elemCount, new HashSet<>());
            kSums.get(elemCount).add(currSum);
            return;
        }
        dfs(nums, i+1, currSum, elemCount, kSums);
        dfs(nums, i+1, currSum + nums[i], elemCount+1, kSums);
    }

    public static int binarySearchLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    public int sum(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res += num;
        }
        return res;
    }


    public int minimumDifference(int[] nums) {
        int n = nums.length;
        if (n == 2) return Math.abs(nums[1] - nums[0]);
        int[][] lists1 = generate(Arrays.copyOfRange(nums, 0, n / 2));
        int[][] lists2 = generate(Arrays.copyOfRange(nums, n / 2, n));
        int ans = Integer.MAX_VALUE;
        for (int d = 0; d <= n / 2; d++) {
            int[] arr1 = lists1[d], arr2 = lists2[d];
            int k = arr1.length;
            int i1 = 0, i2 = 0; // we use two pointers to find two elements in arr1, arr2 with minimum absolute difference
            while (i1 < k && i2 < k) {
                int diff = arr1[i1] - arr2[i2];
                ans = Math.min(ans, Math.abs(diff));
                if (diff <= 0) i1++;
                if (diff >= 0) i2++;
            }
        }
        return ans;
    }

    private static int[][] generate(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;
        int[][] ans = new int[n + 1][];
        int[] pos = new int[n + 1];
        for (int i = 0, binomial = 1; i <= n; i++) {
            ans[i] = new int[binomial]; // number of ways to choose i from n = binomial(i,n)
            binomial = binomial * (n - i) / (i + 1);
        }
        int maxValue = 1 << n;
        for (int key = 0; key < maxValue; key++) {
            int sum1 = 0;
            for (int i = 0; i < n; i++) {
                if ((key >> i & 1) == 1) sum1 += nums[i];
            }
            int sum2 = total - sum1;
            int bits = Integer.bitCount(key);
            ans[bits][pos[bits]++] = sum1 - sum2;
        }
        for (int[] arr : ans) Arrays.sort(arr);
        return ans;
    }
}

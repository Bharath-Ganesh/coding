package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/find-all-subsequences-with-sum-equals-to-k/
 * Given an array arr[] of length N and a number K, the task is to find all the subsequences of the array whose sum of elements is K
 * <p>
 * Input: arr[] = {1, 2, 3}, K = 3
 * Output:
 * 1 2
 * 3
 * <p>
 * Input: arr[] = {17, 18, 6, 11, 2, 4}, K = 6
 * Output:
 * 2 4
 * 6
 */
public class _004_FindAllSubsequenceWithSumEqualsK {

    public static void main(String[] args) {
        int arr[] = {17, 18, 6, 11, 2, 4}, sum = 6;
        System.out.println(countSubsequenceWithSumEqualsKTrial(arr, 0, sum));
        //System.out.println(findAllSubsequenceWithSumEqualsKSecond(arr, sum));
    }

    private static List<List<Integer>> findAllSubsequenceWithSumEqualsKTrial(int arr[], int sum) {

        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findAllSubsequenceWithSumEqualsKTrial(arr, 0, temp, result, sum);
        return result;
    }

    private static List<List<Integer>> countSubsequenceWithSumEqualsKTrial(int arr[], int sum) {

        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        countSubsequenceWithSumEqualsKTrial(arr, 0, sum);
        return result;
    }

    private static int countSubsequenceWithSumEqualsKTrial(int arr[], int index, int sum) {

        if(index == arr.length){
            if(sum == 0){
                return 1;
            }
            return 0;
        }


        int leftCount  = countSubsequenceWithSumEqualsKTrial(arr, index+1, sum - arr[index]);
        int rightCount = countSubsequenceWithSumEqualsKTrial(arr,index+1, sum);
        return leftCount + rightCount;
    }


    private static boolean findOneSubsequenceWithSumEqualsKTrial(int arr[], int index, List<Integer> temp, List<List<Integer>> result, int sum) {

        if(index == arr.length){
            if(sum == 0){
                result.add(new ArrayList<>(temp));
                return true;
            }
            return false;
        }

        temp.add(arr[index]);
        boolean left = findOneSubsequenceWithSumEqualsKTrial(arr, index+1, temp, result, sum - arr[index]);

        if(left) return true;

        temp.remove(temp.size()-1);
        boolean right = findOneSubsequenceWithSumEqualsKTrial(arr,index+1, temp, result, sum);
        if(right) return true;

        return false;
    }

    private static void findAllSubsequenceWithSumEqualsKTrial(int arr[], int index, List<Integer> temp, List<List<Integer>> result, int sum) {

        if(index == arr.length){
            if(sum == 0){
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        temp.add(arr[index]);
        findAllSubsequenceWithSumEqualsKTrial(arr, index+1, temp, result, sum - arr[index]);

        temp.remove(temp.size()-1);
        findAllSubsequenceWithSumEqualsKTrial(arr,index+1, temp, result, sum);

    }


    private static List<List<Integer>> findAllSubsequenceWithSumEqualsK(int[] arr, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        findAllSubsequenceWithSumEqualsK(arr, sum, 0, new ArrayList<>(), res);
        return res;
    }

    private static void findAllSubsequenceWithSumEqualsK(int[] arr, int sum, int index, List<Integer> curr, List<List<Integer>> res) {
        if (index == arr.length) {
            if (sum == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(arr[index]);
        findAllSubsequenceWithSumEqualsK(arr,sum-arr[index],index+1,curr,res);

        curr.remove(curr.size()-1);
        findAllSubsequenceWithSumEqualsK(arr,sum,index+1,curr,res);
    }

    private static List<List<Integer>> findAllSubsequenceWithSumEqualsKSecond(int[] arr, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int index = 0;
        int currSum = 0;
        findAllSubsequenceWithSumEqualsK(arr, res, curr, currSum, sum, index);
        return res;
    }

    private static void findAllSubsequenceWithSumEqualsK(int[] arr, List<List<Integer>> res, List<Integer> curr, int currSum, int sum, int index) {
        if (index >= arr.length) {
            if (sum == currSum) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        // pick at the index
        currSum += arr[index];
        curr.add(arr[index]);
        findAllSubsequenceWithSumEqualsK(arr, res, curr, currSum, sum, index + 1);

        curr.remove(curr.size() - 1);
        currSum -= arr[index];
        findAllSubsequenceWithSumEqualsK(arr, res, curr, currSum, sum, index + 1);

    }
}

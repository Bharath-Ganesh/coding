package com.leetcode.array;

/**
 *941. Valid Mountain Array
 *
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 *
 * Recall that arr is a mountain array if and only if:
 *
 * Input: arr = [3,5,5]
 * Output: false
 *
 * Input: arr = [0,3,2,1]
 * Output: true
 */
public class ValidMoutainArray_13 {

    public static void main(String[] args) {
        int arr[] = {0,3,2,1};
        System.out.println(validMountainArrayLeetcode(arr));
    }

    public static boolean validMountainArray(int[] arr) {

        if(arr.length<3)
            return false;
        int maxIndex=0;
        for(int i=1;i<arr.length;i++){
            if(arr[maxIndex]<arr[i])
                maxIndex=i;
        }

        boolean isIncreasing=false;
        boolean isDecreasing=false;
        for(int i=1;i<=maxIndex;i++){
            if(arr[i]>arr[i-1]){
                isIncreasing=true;
            }else{
                isIncreasing=false;
                break;
            }
        }

        for(int i=maxIndex;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                isDecreasing=true;
            }else{
                isDecreasing=false;
                break;
            }
        }

        if(isIncreasing && isDecreasing){
            return true;
        }
        return false;

    }


    public static boolean validMountainArrayLeetcode(int[] A) {
        if (A.length < 3) return false;
        int start = 0;
        int end = A.length-1;
        while (start < end) {
            if (A[start+1] > A[start]) {
                start++;
            } else if (A[end-1] > A[end]) {
                end--;
            } else {
                break;
            }
        }
        return start != 0 && end != A.length-1 && start == end;
    }
}

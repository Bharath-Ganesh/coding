package com.practice.algorithm;

/**
 * Write a function which takes an array and prints the majority element (if it
 * exists), otherwise prints �No Majority Element�. A majority element in an
 * array A[] of size n is an element that appears more than n/2 times (and hence
 * there is at most one such element).
 *
 * Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
 *
 * Output : 4 Explanation: The frequency of 4 is 5 which is greater than the
 * half of the size of the array size.
 *
 * Input : {3, 3, 4, 2, 4, 4, 2, 4}
 *
 * Output : No Majority Element Explanation: There is no element whose frequency
 * is greater than the half of the size of the array size.
 *
 */
public class MooreVotingAlgo {

    public static void main(String[] args) {
        int[] arr = { 3, 3, 4, 4,4,4, 1, 1, 4 };
        int maj_index = findMajorityElementCandidate(arr);

        if (isMajority(arr, maj_index))
            System.out.println("Majority element : " + arr[maj_index]);
        else
            System.out.println("No Majority Element");

    }

    private static boolean isMajority(int[] arr, int maj_index) {


        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[maj_index]) {
                count++;
                if (count > arr.length / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int findMajorityElementCandidate(int[] arr) {

        int counter=1;
        int maj_index=0;
        for (int i=1;i<arr.length;i++){
            if(arr[maj_index]==arr[i]){
                counter++;
            }else {
                counter--;
            }
            if(counter==0){
                maj_index=i;
                counter=1;
            }
        }
        return maj_index;
    }
}

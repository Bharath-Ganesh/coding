package com.leetcode.array;


/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class _080_MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n=nums1.length;
        int m=nums2.length;
        int low=0;
        int high=n;
        while(low<=high){
            int cut1= (high+low)/2;
            int cut2= (n+m+1)/2-cut1;

            int left1=cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
            int left2=cut2==0?Integer.MIN_VALUE:nums2[cut2-1];

            int right1=cut1==n?Integer.MAX_VALUE:nums1[cut1];
            int right2=cut2==m?Integer.MAX_VALUE:nums2[cut2];

            if(left1<=right2 && left2<=right1){
                if((n+m)%2==0){
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2.0;
                }else{
                    return Math.max(left1,left2);
                }
            }else if(left1>right2){
                high=cut1-1;
            }else{
                low=cut1+1;
            }
        }
        return 0.0;
    }

    public static double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {


        //gap method
        int i, j;
        int n = nums1.length;
        int m = nums2.length;
        double median = 0d;
        if (n == 0) {
            m = m - 1;
            median += nums2[m / 2];
            if (m % 2 == 1) {
                median += nums2[(m / 2) + 1];
                median = median / 2;
            }
            return median;
        } else if (m == 0) {
            n = n - 1;
            median += nums1[n / 2];
            if (n % 2 == 1) {
                median += nums1[(n / 2) + 1];
                median = median / 2;
            }
            return median;
        }
        int gap = n + m;
        int index = gap - 1;

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            for (i = 0; i + gap < n; i++) {
                if (nums1[i] > nums1[gap + i]) {
                    swap(nums1, nums1, i, i + gap);
                }
            }

            for (j = gap > n ? gap - n : 0; j < m && i < n; j++, i++) {
                if (nums1[i] > nums2[j]) {
                    swap(nums1, nums2, i, j);
                }
            }

            if (j < m) {
                for (j = 0; j + gap < m; j++) {
                    if (nums2[j] > nums2[gap + j]) {
                        swap(nums2, nums2, j, j + gap);
                    }
                }
            }

        }
        if (index % 2 == 1) {
            int firstIndex = index / 2;
            int secondIndex = firstIndex + 1;
            if (firstIndex >= n) {
                median += nums2[firstIndex - n];
            } else {
                median += nums1[firstIndex];
            }

            if (secondIndex >= n) {
                median += nums2[secondIndex - n];
            } else {
                median += nums1[secondIndex];
            }
            median = median / 2;
        } else {
            int firstIndex = index / 2;
            if (firstIndex >= n) {
                median += nums2[firstIndex - n];
            } else {
                median += nums1[firstIndex];
            }
        }

        return median;
    }


    private static void swap(int[] nums1, int[] nums2, int pos1, int pos2) {
        int temp = nums1[pos1];
        nums1[pos1] = nums2[pos2];
        nums2[pos2] = temp;
    }


    private static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }
        return (gap / 2) + (gap % 2);
    }
}

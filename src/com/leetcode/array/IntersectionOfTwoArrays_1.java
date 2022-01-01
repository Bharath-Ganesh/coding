package com.leetcode.array;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 * <p>
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 */
public class IntersectionOfTwoArrays_1 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] nums3 = intersectLeetcode(nums1, nums2);
        System.out.println(Arrays.toString(nums3));
    }


    public static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list;
        if (nums1.length > nums2.length) {
            list = findIntersection(nums2, nums1);
        } else {
            list = findIntersection(nums1, nums2);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;


    }


    private static List<Integer> findIntersection(int[] small, int[] big) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(small);
        Arrays.sort(big);
        int sIndex = 0;
        int bIndex = 0;
        while (sIndex < small.length && bIndex < big.length) {
            int smallElement = small[sIndex];
            int bigElement = big[bIndex];
            if (smallElement > bigElement) {
                bIndex++;
            } else if (smallElement < bigElement) {
                sIndex++;
            } else {
                sIndex++;
                bIndex++;
                list.add(smallElement);
            }
        }
        return list;
    }



    public static int[] intersectLeetcode(int[] nums1, int[] nums2) {

        Map<Integer,Integer> freqMap= new HashMap<>();
        List<Integer> list= new ArrayList<>();
        if(nums1.length>nums2.length){
            insertElementIntoMap(freqMap,nums1);
            findIntersection(freqMap,nums2,list);
        }else{
            insertElementIntoMap(freqMap,nums2);
            findIntersection(freqMap,nums1,list);
        }


        int result[]= new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;

    }


    public static void insertElementIntoMap(Map<Integer,Integer> map,int[] arr){
        for(int number: arr){
            map.put(number,map.getOrDefault(number,0)+1);
        }
    }

    public static void findIntersection(Map<Integer,Integer> map,int[] arr,List<Integer> result){
        for(int number: arr){
            if(map.getOrDefault(number,0)>0){
                result.add(number);
                map.put(number,map.get(number)-1);
            }
        }
    }
}

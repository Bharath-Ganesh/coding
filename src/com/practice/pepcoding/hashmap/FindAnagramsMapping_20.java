package com.practice.pepcoding.hashmap;


import java.util.*;

/**
 * Given two arrays, arr1 and arr2, find the index of elements in arr1 on arr2 such that if there are more the
 * one occurrence of elements in arr1, find the immediate index to the occurrence to the previous index
 * int[] arr1= {2,7,9,2,8,1,1,3,9};
 * index        0 1 2 3 4 5 6 7 8
 * int[] arr2= {3,1,2,9,8,1,7,9,2};
 * output:
 * int output ={2,6,3,8,4,1,5,0,7}
 */
public class FindAnagramsMapping_20 {

    public static class Pair {
        int index = 0;
        List<Integer> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 7, 9, 2, 8, 1, 1, 3, 9};
        int[] arr2 = {3, 1, 2, 9, 8, 1, 7, 9, 2};
        int[] output = findAnagramsMappingPepcoding(arr1, arr2);
        System.out.println(Arrays.toString(output));
    }

    private static int[] findAnagramsMapping(int[] arr1, int[] arr2) {
        int[] output = new int[arr1.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            List<Integer> list = map.getOrDefault(arr2[i], new ArrayList<>());
            list.add(i);
            map.put(arr2[i], list);
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            freqMap.put(arr1[i], freqMap.getOrDefault(arr1[i], -1) + 1);
            int freq = freqMap.get(arr1[i]);
            output[i] = map.get(arr1[i]).get(freq);
        }
        return output;
    }


    private static int[] findAnagramsMappingPepcoding(int[] arr1, int[] arr2) {
        int[] output = new int[arr1.length];
        Map<Integer, Pair> map = new HashMap<>();

        //   arr1 = {2, 7, 9, 2, 8, 1, 1, 3, 9};
        //   arr2 = {3, 1, 2, 9, 8, 1, 7, 9, 2};
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                Pair pair = map.get(arr2[i]);
                pair.list.add(i);
            } else {
                Pair pair = new Pair();
                pair.list.add(i);
                map.put(arr2[i], pair);
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            Pair p = map.get(arr1[i]);
            output[i] = p.list.get(p.index);
            p.index++;
        }
        return output;
    }
}

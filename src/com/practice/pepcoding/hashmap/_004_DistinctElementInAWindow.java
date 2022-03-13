package com.practice.pepcoding.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * int[] arr={2,5,5,6,3,2,3,2,4,5,2,2,2,2,3,6};
 * find the number of distinct elements in a window of size k
 * Output when k=4
 * [3, 3, 4, 3, 2, 3, 4, 3, 3, 2, 1, 2, 3]
 */

public class _004_DistinctElementInAWindow {

    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 6, 3, 2, 3, 2, 4, 5, 2, 2, 2, 2, 3, 6};
        int window = 4;
        // countFrequencyUsingHashMap(arr, window);
        // countFrequencyUsingHashMapAndSize(arr, window);
        countFrequencyUsingPepcoding(arr, window);
        // anotherApproach(arr);

    }

    public static void countFrequencyUsingPepcoding(int[] arr, int window) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] uniqueElements = new int[arr.length - (window - 1)];
        int i = 0;
        int j = -1;
        while (i <= window - 2) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            i++;
        }
        i--;
        while (i < arr.length - 1) {
            i++;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            uniqueElements[(i - window) + 1] = map.size();

            j++;
            int freq = map.get(arr[j]);
            if (freq != 1) {
                map.put(arr[j], freq - 1);
            } else {
                map.remove(arr[j]);
            }
        }
        System.out.println(Arrays.toString(uniqueElements));

    }

    public static void countFrequencyUsingHashMap(int[] arr, int window) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] uniqueElements = new int[arr.length - (window - 1)];
        for (int i = 0; i < window; i++) {
            int frequency = map.getOrDefault(arr[i], 0);
            map.put(arr[i], frequency + 1);
        }

        for (int i = window; i < arr.length; i++) {
            int freq = countFrequencyAndRemoveElement(map, arr[i - window]);
            uniqueElements[i - window] = freq;
            int frequency = map.getOrDefault(arr[i], 0);
            map.put(arr[i], frequency + 1);
        }
        int freq = countFrequencyAndRemoveElement(map, arr[arr.length - window]);
        uniqueElements[arr.length - window] = freq;

        System.out.println(Arrays.toString(uniqueElements));

    }

    private static int countFrequencyAndRemoveElement(Map<Integer, Integer> map, int elementRemoved) {
        int count = 0;
        int flag = 0;
        for (int element : map.keySet()) {
            count = count + 1;
            if (element == elementRemoved) {
                int freq = map.get(element);
                if (freq != 1) {
                    map.put(element, freq - 1);
                } else {
                    flag = 1;
                }
            }
        }
        if (flag == 1) {
            map.remove(elementRemoved);
        }
        return count;

    }

    /**
     * @param arr
     * @param window
     */
    public static void countFrequencyUsingHashMapAndSize(int[] arr, int window) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] uniqueElements = new int[arr.length - (window - 1)];
        for (int i = 0; i < window; i++) {
            int frequency = map.getOrDefault(arr[i], 0);
            map.put(arr[i], frequency + 1);
        }
        for (int i = window; i < arr.length; i++) {
            uniqueElements[i - window] = map.size();
            removeElementAlone(map, arr[i - window]);
            int frequency = map.getOrDefault(arr[i], 0);
            map.put(arr[i], frequency + 1);
        }
        int freq = countFrequencyAndRemoveElement(map, arr[arr.length - window]);
        uniqueElements[arr.length - window] = freq;

        System.out.println(Arrays.toString(uniqueElements));

    }

    private static void removeElementAlone(Map<Integer, Integer> map, int elementRemoved) {

        int freq = map.get(elementRemoved);
        if (freq != 1) {
            map.put(elementRemoved, freq - 1);
        } else {
            map.remove(elementRemoved);
        }

    }

    /**
     * @param arr
     */
    public static void anotherApproach(int[] arr) {
        int window = 4;
        int[] uniqueElements = new int[arr.length - (window - 1)];
        for (int i = 0; i <= arr.length - 4; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < 4 + i; j++) {
                set.add(arr[j]);
            }
            uniqueElements[i] = set.size();
        }

        System.out.println(Arrays.toString(uniqueElements));

    }

}

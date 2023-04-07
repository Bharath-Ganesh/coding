package com.leetcode.twoarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/common-elements-in-all-rows-of-a-given-matrix/
 */
public class CommonElementsInARowOfGivenMatrix {

    public static void main(String[] args) {
        int mat[][] =
                {{1, 2, 1, 4, 8},
                        {3, 2, 8, 5, 1},
                        {8, 2, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                };
        System.out.println(printCommonElementsOptimum(mat));
    }

    private static List<Integer> printCommonElementsOptimum(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int element = mat[i][j];
                if (i == 0) {
                    map.put(element, i);
                } else {
                    if (map.containsKey(element)) {
                        if (map.get(element) == (i - 1)) {
                            map.put(element, i);
                        }
                    }
                }
                if (i == mat.length - 1 && map.containsKey(element) && map.get(element) == mat.length - 1) {
                    res.add(element);
                }
            }
        }
        return res;
    }

//    private static List<Integer> printCommonElements(int[][] mat) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < mat[0].length; i++) {
//            set.add(mat[0][i]);
//        }
//
//        for (int i = 1; i < mat.length; i++) {
//            Set<Integer> temp = new HashSet<>();
//            for (int j = 0; j < mat[0].length; j++) {
//                int element = mat[i][j];
//                if (set.contains(element)) {
//                    temp.add(element);
//                }
//            }
//            set = temp;
//        }
//
//        return set.stream().collect(Collectors.toList());
//    }
//
//    private static List<Integer> printCommonElementsOptimum(int[][] mat) {
//        List<Integer> list = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < mat[0].length; i++) {
//            map.put(mat[0][i], 1);
//        }
//
//        for (int i = 1; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                int element = mat[i][j];
//                if (map.containsKey(element)) {
//                    if (map.get(element) == i) {
//                        map.put(element, i + 1);
//                    }
//                    if (i == mat.length - 1 && mat.length == map.get(element)) {
//                        list.add(element);
//                    }
//                }
//            }
//        }
//        return list;
//    }


}

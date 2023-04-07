package com.leetcode.trees.heaps;

import java.util.*;
import java.util.stream.Collectors;

public class LastStoneWeight {

    public static void main(String[] args) {

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        PriorityQueue<Integer> pq=new PriorityQueue(comparator);
        LastStoneWeight obj = new LastStoneWeight();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(obj.lastStoneWeight(stones));
        List<Integer> list = new ArrayList<>();
        List<Integer>[] res = new List[2];
        res[0] = new ArrayList<>();
    }


    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : 1);
        Arrays.stream(stones).boxed().forEach(pq::add);
        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();
            if (first != second) {
                pq.add(Math.abs(first - second));
            }
        }
        return pq.size() == 0 ? 0 : pq.remove();
    }
}

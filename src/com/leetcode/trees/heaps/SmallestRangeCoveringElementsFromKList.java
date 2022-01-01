package com.leetcode.trees.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKList {

    public static void main(String[] args) {
        SmallestRangeCoveringElementsFromKList obj = new SmallestRangeCoveringElementsFromKList();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1, 3, 5, 7, 9));
        res.add(Arrays.asList(0 ,2, 4, 6 ,8));
        res.add(Arrays.asList(2 ,3 ,5 ,7 ,11));
        int[] output = obj.smallestRange(res);
        System.out.println(Arrays.toString(output));
    }

    class Pair implements Comparable<Pair> {
        public List<Integer> list;
        public int index;

        public Pair(List<Integer> list, int index) {
            this.list = list;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return this.list.get(this.index) - o.list.get(o.index);
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Integer maxElement = Integer.MIN_VALUE;
        Integer minElement = Integer.MAX_VALUE;

        int maxSoFar = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        for (List<Integer> list : nums) {
            maxSoFar = Math.max(maxSoFar, list.get(0));
            pq.add(new Pair(list, 0));
        }


        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            int size = poll.list.size();
            int index = poll.index;
            int currMin = poll.list.get(index);
            int currRange = maxSoFar - currMin;
            if (range > currRange) {
                maxElement = maxSoFar;
                minElement = currMin;
                range = currRange;
            }
            if (index == size - 1) {
                break;
            }
            pq.add(new Pair(poll.list, index + 1));
            maxSoFar = Math.max(maxSoFar, poll.list.get(index + 1));
        }
        return new int[]{minElement, maxElement};
    }

}

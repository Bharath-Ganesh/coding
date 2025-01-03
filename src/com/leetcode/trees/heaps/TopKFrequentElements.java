package com.leetcode.trees.heaps;

import java.util.*;


public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();

        List<Integer> list = Arrays.asList(1,5,2,3,8,15,12);
        Collections.sort(list, (o1, o2) -> (o1 - o2) * -1);
        System.out.println(list);
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = obj.topKFrequentUsingComparator(nums, k);
        int[] res1 = obj.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }

    class FreqPair implements Comparable<FreqPair> {

        int num;
        int freq;

        public FreqPair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(FreqPair pair) {
            return this.freq > pair.freq ? 1 : -1;
        }

    }

    class Pair {

        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(FreqPair pair) {
            return this.freq > pair.freq ? 1 : -1;
        }

    }


    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        int size = map.size();

        FreqPair[] fp = new FreqPair[size];
        int count = 0;
        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
            fp[count++] = new FreqPair(element.getKey(), element.getValue());
        }


        PriorityQueue<FreqPair> minHeap = new PriorityQueue<>();

        int i;
        for (i = 0; i < k; i++) {
            minHeap.add(fp[i]);
        }

        for (; i < size; i++) {
            FreqPair currPair = fp[i];
            if (minHeap.peek().freq < currPair.freq) {
                minHeap.remove();
                minHeap.add(currPair);
            }
        }
        int[] res = new int[k];
        i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.remove().num;
        }
        return res;

    }

    public int[] topKFrequentUsingComparator(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int freq = map.getOrDefault(nums[i], 0);
            freq += 1;
            maxFreq = Math.max(maxFreq, freq);
            map.put(nums[i], freq);
        }

        Comparator<Pair> c = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.freq > o2.freq ? -1 : 1;
            }
        };
        // PriorityQueue<FreqPair> pq = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);

        for (Map.Entry<Integer, Integer> freqMap : map.entrySet()) {
            Pair freqPair = new Pair(freqMap.getKey(), freqMap.getValue());
            maxHeap.add(freqPair);
        }

        int[] res = new int[k];
        while (!maxHeap.isEmpty() && k > 0) {
            res[--k] = maxHeap.remove().num;
        }
        return res;

    }


}

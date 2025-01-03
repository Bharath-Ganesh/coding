package com.practice.uiuc.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        char a = '3';
        int b = a - '0';
        System.out.println(b * b);
        TopKFrequentElements obj = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] ints = obj.topKFrequent(nums, k);
        Arrays.stream(ints).forEach(x-> System.out.print(x + " "));
    }

    class Pair  {

        int freq;
        int element;

        public Pair(int element, int freq){
            this.element = element;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[k];

        Comparator<Pair> maxInt = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return -1 * (o1.freq - o2.freq);
            }
        };

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(maxInt);



        for(int i=0; i<nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer,Integer> m : freqMap.entrySet()){
            Pair p=new Pair(m.getKey(), m.getValue());
            maxHeap.add(p);
        }

        int count = 0;
        while (!maxHeap.isEmpty() && k>0){
            result[count++] = maxHeap.remove().element;
            k--;
        }
        return result;

    }
}

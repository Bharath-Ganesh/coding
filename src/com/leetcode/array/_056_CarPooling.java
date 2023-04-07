package com.leetcode.array;

import java.util.*;

/**
 * 1094. Car Pooling
 *
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
 *
 * You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the
 * ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively.
 * The locations are given as the number of kilometers due east from the car's initial location.
 *
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 *
 * int trips[][]={{4,5,6},{6,4,7},{4,3,5},{2,3,5}};
 * int capacity=13;
 *
 */
public class _056_CarPooling {

    public static void main(String[] args) {
        int trips[][]={{4,5,6},{6,4,7},{4,3,5},{2,3,5}};
        int capacity=13;
        System.out.println(carPooling(trips,capacity));
    }

    public static boolean carPooling(int[][] trips, int capacity) {

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<trips.length;i++){
            int passenger=trips[i][0];
            int start=trips[i][1];
            int end=trips[i][2];

            List<Integer> dist=new ArrayList<>();
            dist.add(start);
            dist.add(passenger);
            list.add(dist);

            List<Integer> dist2=new ArrayList<>();
            dist2.add(end);
            dist2.add(-passenger);
            list.add(dist2);
        }
        System.out.println(list);
        Collections.sort(list, Comparator.comparing(o -> o.get(0)));
        System.out.println(list);


        for(int i=0;i<list.size();i++){
            capacity-=list.get(i).get(1);
            if(capacity<0){
                return false;
            }
        }
        return true;

    }
}

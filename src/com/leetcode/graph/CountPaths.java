package com.leetcode.graph;

import java.util.*;

public class CountPaths {

    public static void main(String[] args) {
        CountPaths obj = new CountPaths();
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        System.out.println(obj.countPaths(n, roads));
    }

    class Pair {

        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }


    public int countPaths(int n, int[][] roads) {

        Comparator<Pair> comparator = (p1, p2) -> p1.distance - p2.distance;
        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);

        List<List<Pair>> graph = new ArrayList<>();

        //Construct a graph
        for (int node = 0; node < n; node++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int edgeWeight = roads[i][2];
            graph.get(u).add(new Pair(edgeWeight, v));
            graph.get(v).add(new Pair(edgeWeight, u));
        }


        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;
        pq.add(new Pair(0, 0));


        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int dist = p.distance;
            int u = p.node;

            for (Pair adjNode : graph.get(u)) {
                int edgeWeight = adjNode.distance;
                int v = adjNode.node;


                if (dist + edgeWeight < distance[v]) {
                    ways[v] = 1;
                    distance[v] = dist + edgeWeight;
                    pq.add(new Pair(distance[v], v));
                } else if (dist + edgeWeight == distance[v]) {
                    ways[v] = ways[u] + ways[v];
                }
            }

        }
        return distance[n - 1] == (int) 1e9 ? -1 : ways[n - 1];
    }
}

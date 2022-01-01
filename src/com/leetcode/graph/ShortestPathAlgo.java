package com.leetcode.graph;

import java.lang.reflect.Array;
import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
 */

public class ShortestPathAlgo {

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(shortestPath(n, m, edges));
    }

    static class Pair {

        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        List<List<Pair>> graph = new ArrayList<>();

        for (int node = 0; node <= n; node++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            graph.get(u).add(new Pair(weight, v));
            graph.get(v).add(new Pair(weight, u));
        }


        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);
        distance[1] = 0;

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        Comparator<Pair> comp = (p1, p2) -> p1.distance - p2.distance;
        PriorityQueue<Pair> pq = new PriorityQueue<>(comp);
        pq.add(new Pair(0, 1));
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int dist = p.distance;
            int u = p.node;

            for (Pair adjNode : graph.get(u)) {
                int edgeWeight = adjNode.distance;
                int v = adjNode.node;

                if (dist + edgeWeight < distance[v]) {
                    distance[v] = dist + edgeWeight;
                    pq.add(new Pair(distance[v], v));
                    parent[v] = u;
                }
            }

        }

        if (distance[n] == 1e9) {
            return Arrays.asList(-1);
        }

        List<Integer> res = new ArrayList<>();
        res.add(n);
        while (parent[n] != n) {
            res.add(parent[n]);
            n = parent[n];
        }
        Collections.reverse(res);
        return res;

    }
}

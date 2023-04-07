package com.leetcode.graph;

import java.util.*;

public class CreateGraph<T extends Integer> {

    class Pair {
        T v;
        int weight;

        Pair(T v, Integer weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    public Map<T, List<Pair>> adjList = new HashMap<>();


    void addEdge(T u, T v, int weight, Boolean biDir) {
        Pair p = new Pair(v, weight);
        if (adjList.containsKey(u)) {
            adjList.get(u).add(p);
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(p);
            adjList.put(u, list);
        }
        if (biDir) {
            addEdge(v, u, weight, false);
        }
    }

    ArrayList<T> bfs(T startingNode) {
        ArrayList<T> bfs = new ArrayList<>();
        int n = adjList.size();
        boolean[] visited = new boolean[n + 1];
        Queue<T> queue = new LinkedList<>();
        queue.add(startingNode);
        visited[0] = true;

        while (!queue.isEmpty()) {
            T node = queue.poll();
            bfs.add(node);
            List<Pair> list = adjList.getOrDefault(node,new ArrayList<>());
            for (Pair p : list) {
                Integer value = p.v;
                if (visited[value] == false) {
                    visited[value] = true;
                    queue.add(p.v);
                }
            }
        }
        return bfs;
    }


    public static void main(String[] args) {
        CreateGraph<Integer> graph = new CreateGraph<>();
        graph.addEdge(0, 1, 4, false);
        graph.addEdge(0, 7, 8, false);
        graph.addEdge(1, 7, 11, false);
        graph.addEdge(1, 2, 8, false);
        graph.addEdge(7, 8, 7, false);
        graph.addEdge(2, 8, 2, false);
        graph.addEdge(8, 6, 6, false);
        graph.addEdge(2, 5, 4, false);
        graph.addEdge(6, 5, 2, false);
        graph.addEdge(2, 3, 7, false);
        graph.addEdge(3, 3, 14, false);
        graph.addEdge(3, 4, 9, false);
        graph.addEdge(5, 4, 10, false);
        graph.addEdge(7, 6, 1, false);
        ArrayList<Integer> bfs = graph.bfs(0);
        System.out.println(bfs);
    }

}


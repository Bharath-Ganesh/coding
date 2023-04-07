package com.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {

    public static void main(String[] args) {
        ShortestPathDAG obj = new ShortestPathDAG();
        int n = 6, m = 7;
        int[][] edge = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        System.out.println(Arrays.toString(obj.shortestPath(n, m, edge)));
    }

    class Pair {

        int edge;
        int weight;

        public Pair(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }

    public void toposort(int u, boolean[] visited, Stack<Integer> stack, List<List<Pair>> graph) {
        visited[u] = true;

        for (int i = 0; i < graph.get(u).size(); i++) {
            // there's an edge from u->v
            int v = graph.get(u).get(i).edge;
            if(visited[v]==false){
                toposort(v,visited,stack,graph);
            }
        }

        stack.push(u);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        //Code here
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            Pair p = new Pair(v, wt);
            graph.get(u).add(p);
        }

        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int node = 0; node < N; node++) {
            if (visited[node] == false) {
                toposort(node, visited, stack, graph);
            }
        }


        int[] distance = new int[N];
        Arrays.fill(distance,(int) 1e9);
        distance[stack.peek()]=0;
        while (!stack.isEmpty()) {
            Integer node = stack.pop();

            for (int i = 0; i < graph.get(node).size(); i++) {
                // there's an edge from u->v
                int v = graph.get(node).get(i).edge;
                int wt = graph.get(node).get(i).weight;

                if (distance[node] + wt < distance[v]) {
                    distance[v] = distance[node] + wt;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (distance[i] == (int) 1e9) {
                distance[i] = -1;
            }
        }
        return distance;
    }
}

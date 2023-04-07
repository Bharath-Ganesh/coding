package com.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectedCyclic {

    public static void main(String[] args) {
        DirectedCyclic obj = new DirectedCyclic();
        List<List<Integer>> adj = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList(4, 5), Arrays.asList(6), Arrays.asList(6), Arrays.asList(7), Arrays.asList(), Arrays.asList(1, 9), Arrays.asList(10), Arrays.asList(8), Arrays.asList());
        obj.isCyclic(adj.size(),adj);
    }

    public boolean isCyclic(int V, List<List<Integer>> adj) {
        // code here

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int node = 0; node < V; node++) {
            if (visited[node] == false) {
                if (dfs(node, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (Integer adjNode : adj.get(node)) {
            if (visited[adjNode] == false) {
                if (dfs(adjNode, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[adjNode] == true) {
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
}

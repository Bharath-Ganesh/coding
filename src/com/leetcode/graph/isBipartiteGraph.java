package com.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class isBipartiteGraph {
    public static void main(String[] args) {
        isBipartiteGraph obj = new isBipartiteGraph();
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(obj.isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int node = 0; node < n; node++) {
            if (color[node] == -1) {
                if (!bfs(color, node, graph)) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean bfs(int[] color, int startingNode, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingNode);
        color[startingNode] = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            int toBeColoredWith = 1 - color[node];
            for (Integer adjNode : graph[node]) {
                //node is not visited
                if (color[adjNode] == -1) {
                    color[adjNode] = toBeColoredWith;
                    queue.add(adjNode);
                } else if (color[adjNode] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}

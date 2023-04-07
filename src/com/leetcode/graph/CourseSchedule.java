package com.leetcode.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {0,1}, {3, 1}, {3, 2}};
        int[] order = obj.findOrder(numCourses, prerequisites);
        Arrays.stream(order).forEach(x-> System.out.print(x + " "));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(u).add(v);
        }
        return toposort(graph, numCourses);
    }

    public int[] toposort(List<List<Integer>> graph, int n) {
        int[] indegree = new int[n];
        for (int node = 0; node < n; node++) {
            for (Integer u : graph.get(node)) {
                indegree[u]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int node = 0; node < n; node++) {
            if (indegree[node] == 0) {
                queue.add(node);
            }
        }

        int count = 0;
        int[] res = new int[n];
        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            res[(n - 1) - count++] = node;
            for (Integer adjNode : graph.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }
        //if count==n ; DAG
        return count == n ? res : new int[0];
    }
}

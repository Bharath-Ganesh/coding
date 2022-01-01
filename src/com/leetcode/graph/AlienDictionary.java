package com.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary obj = new AlienDictionary();
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int K = 4;
        System.out.println(obj.findOrder(dict, dict.length, K));
    }

    public String findOrder(String[] dict, int N, int K) {
        // Write your code here
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < N - 1; i++) {
            String firstWord = dict[i];
            String secondWord = dict[i + 1];
            compareWord(firstWord, secondWord, graph);
        }

        int[] res = toposort(graph, K);
        StringBuilder answer = new StringBuilder();
        for (int character : res) {
            char ch = (char) ((int) 'a' + character);
            answer.append(ch);
        }
        return answer.toString();
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
            res[count++] = node;
            for (Integer adjNode : graph.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }
        //if count==n ; DAG
        return res;
    }

    public void compareWord(String firstWord, String secondWord, List<List<Integer>> graph) {

        int n = firstWord.length();
        int m = secondWord.length();

        for (int i = 0; i < Math.min(n, m); i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i)) {
                int u = firstWord.charAt(i) - 'a';
                int v = secondWord.charAt(i) - 'a';
                graph.get(u).add(v);
                break;
            }
        }
    }
}

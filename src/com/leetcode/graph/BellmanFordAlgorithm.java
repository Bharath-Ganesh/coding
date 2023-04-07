package com.leetcode.graph;

import java.util.Arrays;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
 */
public class BellmanFordAlgorithm {

    public static void main(String[] args) {
        BellmanFordAlgorithm obj=new BellmanFordAlgorithm();
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(0, 1, 5), Arrays.asList(1, 0, 3), Arrays.asList(1, 2, -1), Arrays.asList(2, 0, 1));
        int[] res = bellman_ford(3, arr, 2);
        System.out.println(Arrays.toString(res));
    }

    static int[] bellman_ford(int V, List<List<Integer>> edges, int S) {
        // Write your code here

        int[] distance=new int[V];
        Arrays.fill(distance,(int)1e8);
        distance[S]=0;



        for(int relaxation=0;relaxation<V-1;relaxation++){

            for(List<Integer> edge : edges){
                int u=edge.get(0);
                int v=edge.get(1);
                int weight=edge.get(2);

                if(distance[u]!=(int)1e8 && distance[u]+weight<distance[v]){
                    distance[v]=distance[u]+weight;
                }
            }
        }

        for(List<Integer> edge : edges){
            int u=edge.get(0);
            int v=edge.get(1);
            int weight=edge.get(2);

            if(distance[u]!=(int)1e8 && distance[u]+weight<distance[v]){
                return new int[]{-1};
            }
        }

        return distance;

    }
}

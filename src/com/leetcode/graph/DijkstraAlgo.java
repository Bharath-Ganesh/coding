package com.leetcode.graph;

import java.util.*;

public class DijkstraAlgo {

    public static void main(String[] args) {
        int V=3;
        int S=0;
        List<List<List<Integer>>> adj = Arrays.asList(Arrays.asList(Arrays.asList(1, 1), Arrays.asList(2, 6)), Arrays.asList(Arrays.asList(2, 3), Arrays.asList(0, 1)), Arrays.asList(Arrays.asList(1, 3), Arrays.asList(0, 6)));
        System.out.println(Arrays.toString(dijkstra(V,adj,S)));
    }

    static class Pair {

        int weight;
        int node;

        public Pair(int weight,int node){
            this.weight=weight;
            this.node=node;
        }

    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S)
    {
        // Write your code here

        int[] distance=new int[V];
        Arrays.fill(distance,(int)1e9);

        Comparator<Pair> comparator=(Comparator.comparingInt(p -> p.weight));

        PriorityQueue<Pair> pq=new PriorityQueue<>(comparator);
        distance[S]=0;
        pq.add(new Pair(0,S));

        while(!pq.isEmpty()){
            int dist=pq.peek().weight;
            int u=pq.peek().node;
            pq.remove();

            for(int index=0;index<adj.get(u).size();index++){
                int edgeWeight=adj.get(u).get(index).get(1);
                int v=adj.get(u).get(index).get(0);

                if(dist+edgeWeight<distance[v]){
                    distance[v]=dist+edgeWeight;
                    pq.add(new Pair(distance[v],v));
                }
            }
        }
        return distance;

    }
}

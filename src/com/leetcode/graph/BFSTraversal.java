package com.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean[] visited=new boolean[V];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visited[0]=true;

        while(!queue.isEmpty()){
            Integer node=queue.poll();
            bfs.add(node);

            for(Integer currNode :adj.get(node)){
                if(visited[currNode]==false){
                    visited[currNode]=true;
                    queue.add(currNode);
                }
            }
        }
        return bfs;
    }
}

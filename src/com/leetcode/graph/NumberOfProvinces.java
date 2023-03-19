package com.leetcode.graph;

import java.util.*;

public class NumberOfProvinces {

    public static void main(String[] args) {
        NumberOfProvinces obj = new NumberOfProvinces();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(obj.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList=constructAdj(isConnected);
        Set<Integer> set=new HashSet<>();
        int n=isConnected.length;
        int provincesCount=0;
        for(int i=1;i<=n;i++){
            if(set.add(i)){
                provincesCount++;
                bfsOfGraph(i,adjList,set);
            }
        }
        return provincesCount;
    }

    public void bfsOfGraph(Integer root,List<List<Integer>> adj,Set<Integer> set) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Integer node=queue.remove();
            for(Integer val :adj.get(node)){
                if(set.add(val)){
                    queue.add(val);
                }
            }
        }
    }

    public List<List<Integer>> constructAdj(int[][] isConnected) {
        List<List<Integer>> adjList=new ArrayList<>();
        adjList.add(new ArrayList<>());
        int rows=isConnected.length;
        int cols=isConnected[0].length;
        for(int i=0;i<rows;i++){
            adjList.add(new ArrayList<>());
            for(int j=0;j<cols;j++){
                if(i!=j && isConnected[i][j]==1){
                    adjList.get(i+1).add(j+1);
                }
            }
        }
        return adjList;
    }

//    public int findCircleNum(int[][] isConnected) {
//        ArrayList<ArrayList<Integer>> adj=getAdjList(isConnected);
//
//        int V=isConnected.length;
//        boolean visited[]=new boolean[V+1];
//        int provinces=0;
//        for(int i=1;i<=V;i++){
//            if(visited[i]==false){
//                provinces++;
//                dfsOfGraph(i,visited,adj);
//            }
//        }
//        return provinces;
//    }
//
//    public void dfsOfGraph(int node,boolean visited[],ArrayList<ArrayList<Integer>> adj) {
//        visited[node]=true;
//
//        for(int ele : adj.get(node)){
//            if(visited[ele]==false){
//                dfsOfGraph(ele,visited,adj);
//            }
//        }
//
//    }
//
//    private ArrayList<ArrayList<Integer>> getAdjList(int[][] isConnected){
//        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
//        int V=isConnected.length;
//
//        for(int i=0;i<=V;i++){
//            adj.add(new ArrayList<>());
//        }
//
//        for(int i=0;i<V;i++){
//            for(int j=0;j<V;j++){
//                if(isConnected[i][j]==1 && i!=j){
//                    adj.get(i+1).add(j+1);
//                }
//            }
//        }
//        return adj;
//    }
}

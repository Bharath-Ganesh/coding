package com.leetcode.graph;

import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1
 */


public class NumberOfDistinctIslands {


    public static void main(String[] args) {
        NumberOfDistinctIslands obj = new NumberOfDistinctIslands();
        int grid[][] = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        System.out.println(obj.countDistinctIslands(grid));
    }

    class Pair {
        int row;
        int col;

        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<List<List<Integer>>> set=new HashSet<>();
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i][j]==false && grid[i][j]==1){
                    List<List<Integer>> list=bfs(grid,visited,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();

    }


    public List<List<Integer>> bfs(int[][] grid,boolean visited[][],int baseRow,int baseCol){

        int rows=grid.length;
        int cols=grid[0].length;

        Queue<Pair> queue=new LinkedList<>();
        Pair p=new Pair(baseRow,baseCol);
        queue.add(p);
        visited[baseRow][baseCol]=true;
        List<List<Integer>> list=new ArrayList<>();
        int[] dlRow={-1,0,1,0};
        int[] dlCol={0,1,0,-1};

        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            list.add(Arrays.asList(row-baseRow,col-baseCol));
            queue.remove();
            for(int i=0;i<4;i++){
                int cRow=row+dlRow[i];
                int cCol=col+dlCol[i];
                if(cRow>=0 && cCol>=0 && cRow<rows && cCol<cols && grid[cRow][cCol]==1 && visited[cRow][cCol]==false){
                    visited[cRow][cCol]=true;
                    queue.add(new Pair(cRow,cCol));
                }
            }
        }
        return list;
    }


//    class Pair {
//
//        int row;
//        int col;
//
//        static final String PATTERN="(%d,%d)";
//
//        Pair(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//
//        @Override
//        public String toString() {
//            return String.format(PATTERN,this.row,this.col);
//        }
//    }
//
//    int countDistinctIslands(int[][] grid) {
//        // Your Code here
//
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//        boolean[][] visited = new boolean[rows][cols];
//        Set<List<String>> set = new HashSet<>();
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == 1 && visited[i][j] == false) {
//                    List<String> list = new ArrayList<>();
//                    dfs(visited, grid, i, j, i, j, list);
//                    set.add(list);
//                }
//            }
//        }
//        return set.size();
//    }
//
//
//    public void dfs(boolean[][] visited, int[][] grid, int row, int col, int baseRow, int baseCol, List<String> list) {
//
//        visited[row][col] = true;
//        Pair p = new Pair(row - baseRow, col - baseCol);
//        list.add(p.toString());
//
//        int[] dlRow = {-1, 0, +1, 0};
//        int[] dlCol = {0, +1, 0, -1};
//
//
//        for (int i = 0; i < 4; i++) {
//            int nRow = row + dlRow[i];
//            int nCol = col + dlCol[i];
//
//            if (nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length && grid[nRow][nCol] == 1 && visited[nRow][nCol] == false) {
//
//                dfs(visited, grid, nRow, nCol, baseRow, baseCol, list);
//            }
//        }
//
//    }
}

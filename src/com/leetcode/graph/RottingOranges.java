package com.leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {

    public static void main(String[] args) {
        RottingOranges obj = new RottingOranges();
        int[][] oranges = {{2, 1, 1}, {1, 1, 0}, {0, 1, 2},{1, 1, 0}};
        System.out.println(obj.orangesRotting(oranges));
    }

    class Pair{

        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue=new LinkedList<>();
        int rows=grid.length;
        int cols=grid[0].length;
        int countOne=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    Pair p=new Pair(i,j);
                    queue.add(p);
                }else if(grid[i][j]==1){
                    countOne++;
                }
            }
        }
        int minTime=minTimeForOrangeToRot(queue,grid,countOne);
        return minTime;
    }

    public int minTimeForOrangeToRot(Queue<Pair> queue,int[][] grid,int countOne) {


        int minTimeTaken=0;
        int[] di={-1,0,1,0};
        int[] dj={ 0,-1,0,1};
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i1=0;i1<size;i1++){
                Pair p=queue.remove();
                int row=p.row;
                int col=p.col;
                visited[row][col]=true;
                //adjacent node are 1
                for(int k=0;k<4;k++){
                    int i=row+di[k];
                    int j=col+dj[k];
                    if(i>=0 && i<rows && j>=0 && j<cols && grid[i][j]==1 && visited[i][j]==false){
                        countOne--;
                        visited[i][j]=true;
                        p=new Pair(i,j);
                        queue.add(p);
                    }
                }
            }
            minTimeTaken++;
        }

        return countOne==0?minTimeTaken-1:-1;
    }

//    class Pair {
//
//        int row;
//        int col;
//
//        Pair(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//    }
//
//
//    public int orangesRotting(int[][] grid) {
//
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//        Queue<Pair> queue = new LinkedList<>();
//
//        boolean[][] visited = new boolean[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == 2) {
//                    visited[i][j]=true;
//                    queue.add(new Pair(i, j));
//                }
//            }
//        }
//        int totalTime=bfs(visited, grid, queue);
//        if (!checkIfAllAreRotten(grid)) return -1;
//        return totalTime;
//    }
//
//    private boolean checkIfAllAreRotten(int[][] grid) {
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] != 0 && grid[i][j] == 1) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public int bfs(boolean[][] visited, int[][] grid, Queue<Pair> queue) {
//
//        int time = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            boolean isRotting = false;
//            for (int j = 0; j < size; j++) {
//                int cRow = queue.peek().row;
//                int cCol = queue.peek().col;
//                queue.remove();
//
//                int[] dlRow = {-1, 0, +1, 0};
//                int[] dlCol = {0, +1, 0, -1};
//
//                for (int i = 0; i < 4; i++) {
//                    int nRow = cRow + dlRow[i];
//                    int nCol = cCol + dlCol[i];
//
//                    if (nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length && grid[nRow][nCol] == 1 && visited[nRow][nCol] == false) {
//                        visited[nRow][nCol] = true;
//                        grid[nRow][nCol] = 2;
//                        queue.add(new Pair(nRow, nCol));
//                        isRotting = true;
//                    }
//                }
//            }
//            if (isRotting) {
//                time += 1;
//            }
//        }
//
//        return time;
//    }

}

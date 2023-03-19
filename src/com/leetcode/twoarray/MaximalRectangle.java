package com.leetcode.twoarray;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        MaximalRectangle obj=new MaximalRectangle();
        char matrix[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(obj.maximalRectangle(matrix));
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int maxArea=0;
        int[] heights=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                char element=matrix[i][j];
                int num=element=='1'?1:0;
                if(i==0){
                    heights[j]=num;
                }else{
                    heights[j]=num==0?0:heights[j]+num;
                }
            }
            maxArea=Math.max(largestArea(heights),maxArea);
        }
        return maxArea;
    }


    public static int largestArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int[] nsl=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            int element=heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>=element){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=stack.peek();
            }
            stack.push(i);
        }

        stack=new Stack();
        int[] nsr=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            int element=heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>=element){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsr[i]=heights.length;
            }else{
                nsr[i]=stack.peek();
            }
            stack.push(i);
        }

        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int area=((nsr[i]-nsl[i])-1)*heights[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}

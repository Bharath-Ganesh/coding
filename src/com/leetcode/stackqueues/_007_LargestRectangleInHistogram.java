package com.leetcode.stackqueues;

import java.util.Arrays;
import java.util.Stack;

/**
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 */

public class _007_LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {

        int n=heights.length;
        int[] nsr=new int[n];

        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int num=heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>=num){
                stack.pop();
            }

            nsr[i]=stack.isEmpty()?n:heights[stack.peek()];
            stack.push(i);
        }


        stack=new Stack<>();
        int[] nsl=new int[n];
        for(int i=0;i<n;i++){
            int num=heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>=num){
                stack.pop();
            }

            nsl[i]=stack.isEmpty()?-1:heights[stack.peek()];
            stack.push(i);
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
            int area=heights[i]* ( (nsr[i]-nsl[i])-1 );
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }

//    public static int largestRectangleAreas(int[] heights) {
//        Stack<Integer> stack=new Stack<>();
//        int[] nsl=new int[heights.length];
//        for(int i=0;i<heights.length;i++){
//            int element=heights[i];
//            while(!stack.isEmpty() && heights[stack.peek()]>=element){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                nsl[i]=-1;
//            }else{
//                nsl[i]=stack.peek();
//            }
//            stack.push(i);
//        }
//
//        stack=new Stack();
//        int[] nsr=new int[heights.length];
//        for(int i=heights.length-1;i>=0;i--){
//            int element=heights[i];
//            while(!stack.isEmpty() && heights[stack.peek()]>=element){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                nsr[i]=heights.length;
//            }else{
//                nsr[i]=stack.peek();
//            }
//            stack.push(i);
//        }
//
//        int maxArea=0;
//        for(int i=0;i<heights.length;i++){
//            int area=((nsr[i]-nsl[i])-1)*heights[i];
//            maxArea=Math.max(maxArea,area);
//        }
//        return maxArea;
//    }
//
//    public static int largestRectangleAreaOptimum(int[] heights) {
//
//        //The intuition behind find lse and rse is that
//        // The maximum continous width that will be available is that point at which for the particular height
//        //when we encounter a tower with smaller height either to the left and right
//        //So the question boils down to asking finding the left and right smaller element
//        //index of the next smaller element to the left
//        int lse[] = new int[heights.length];
//
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < heights.length; i++) {
//            int element = heights[i];
//            while (!stack.isEmpty() && heights[stack.peek()] >= element) {
//                stack.pop();
//            }
//            lse[i] = stack.isEmpty() ? -1 : stack.peek();
//            stack.push(i);
//        }
//        //index of the next smaller element to the right
//        stack=new Stack<>();
//        int rse[] = new int[heights.length];
//
//        for (int i = heights.length - 1; i >= 0; i--) {
//            int element = heights[i];
//            while (!stack.isEmpty() && heights[stack.peek()] >= element) {
//                stack.pop();
//            }
//            rse[i] = stack.isEmpty() ? heights.length : stack.peek();
//            stack.push(i);
//        }
//
//        //The area of the rectangle would be res[i]-lse[i]-1*height
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int width = rse[i] - lse[i] - 1;
//            int area = width * heights[i];
//            maxArea = Math.max(maxArea, area);
//        }
//        return maxArea;
//    }
//
//
//    private static int largestRectangleArea(int[] heights) {
//        Stack<Integer> stack=new Stack();
//        int[] rse=new int[heights.length];
//        Arrays.fill(rse,heights.length);
//        for(int i=0;i<heights.length;i++){
//            int num=heights[i];
//            while(!stack.isEmpty() && heights[stack.peek()]>num){
//                rse[stack.pop()]=i;
//            }
//            stack.push(i);
//        }
//
//        stack=new Stack();
//        int[] lse=new int[heights.length];
//        Arrays.fill(lse,-1);
//        for(int i=heights.length-1;i>=0;i--){
//            int num=heights[i];
//            while(!stack.isEmpty() && heights[stack.peek()]>num){
//                lse[stack.pop()]=i;
//            }
//            stack.push(i);
//        }
//
//        int maxArea=0;
//        for(int i=0;i<heights.length;i++){
//            maxArea=Math.max(maxArea,heights[i]*( (rse[i]-lse[i])-1));
//        }
//        return maxArea;
//    }
//
//
//    /**
//     * Brute Force approach
//     *
//     * @param heights
//     * @return
//     */
//    public static int largestRectangleAreaBruteForce(int[] heights) {
//        int maxArea = heights[0];
//        for (int i = 0; i < heights.length; i++) {
//            int height = heights[i];
//            int left = findLeftWidth(i - 1, height, heights);
//            int right = findRightWidth(i + 1, height, heights);
//            int totalWidth = left + right + 1;
//            maxArea = Math.max(maxArea, height * totalWidth);
//        }
//        return maxArea;
//    }
//
//
//    public static int findLeftWidth(int left, int height, int[] heights) {
//        int width = 0;
//        for (int i = left; i >= 0; i--) {
//            if (heights[i] < height) {
//                break;
//            }
//            width += 1;
//        }
//        return width;
//    }
//
//
//    public static int findRightWidth(int right, int height, int[] heights) {
//        int width = 0;
//        for (int i = right; i < heights.length; i++) {
//            if (heights[i] < height) {
//                break;
//            }
//            width += 1;
//        }
//        return width;
//    }
}

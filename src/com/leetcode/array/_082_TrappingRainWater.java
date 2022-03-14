package com.leetcode.array;

/**
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 */
public class _082_TrappingRainWater {

    public static void main(String[] args) {
        //prefix      0,1,1,2,2,2,2,3,3,3,3,3
        //suffix      3,3,3,3,3,3,3,3,2,2,2,1
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int trapped=0;
        int leftMax=0;
        int rightMax=0;
        int leftP=0;
        int rightP=height.length-1;
        while(leftP<rightP){
            if(height[leftP]<=height[rightP]){
                if(height[leftP]>=leftMax){
                    leftMax=height[leftP];
                }else{
                    trapped+=leftMax-height[leftP];
                }
                leftP++;
            }else {
                if(height[rightP]>=rightMax){
                    rightMax=height[rightP];
                }else{
                    trapped+=rightMax-height[rightP];
                }
                rightP--;
            }
        }
        return trapped;
    }

    public static int trapBruteForce(int[] height) {
        int trapped=0;
        int[] prefix=new int[height.length];
        int[] suffix=new int[height.length];
        prefix[0]=height[0];
        suffix[height.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++){
            prefix[i]=Math.max(prefix[i-1],height[i]);
        }

        for(int i=height.length-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],height[i]);
        }

        for(int i=1;i<height.length-1;i++){
            if(prefix[i]>height[i]){
                trapped+=Math.min(prefix[i],suffix[i])-height[i];
            }
        }
        return trapped;
    }
}

package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003
 */
public class NinjaTraining {

    public static void main(String[] args) {
        NinjaTraining obj = new NinjaTraining();
        int[][] points = {{10, 40, 70}, {20, 50, 90}, {30, 60, 90} , {10,30,20}};
        //  int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        // int[][] points = {{10, 5, 1}, {5, 100, 11}};
        //  int merit = ninjaTraining(points.length, points);
        int merit = ninjaTrainingTrial(points.length, points);
        System.out.println(merit);
        //int merit2 = ninjaTrainingTabulation(points.length, points);

        // System.out.println(merit);
        // System.out.println(merit2);

    }

    public static int ninjaTrainingRecursive(int n, int points[][]) {

        int[][] dp = new int[n][4];
        Arrays.stream(dp).forEach(x->Arrays.fill(x,-1));
        return ninjaTraining(points, 3, n - 1, dp);


        // Write your code here..
    }

    public static int ninjaTraining(int n, int points[][]) {
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        for (int day = 1; day < n; day++) {
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }

    public static int ninjaTrainingTrial(int n, int points[][]) {

        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        for(int days=1;days<n;days++){
            for(int prevDayPoints=0;prevDayPoints<=3;prevDayPoints++){
                int maxPoints=Integer.MIN_VALUE;
                for(int pt=0;pt<3;pt++){
                    if(pt!=prevDayPoints){
                        int totalPoints=points[days][pt] + dp[days-1][pt];
                        maxPoints=Math.max(maxPoints,totalPoints);
                    }
                }
                dp[days][prevDayPoints]=maxPoints;
            }
        }
        return dp[n-1][3];
        // Write your code here..
    }


    public static int ninjaTrainingTabulation(int n, int points[][]) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(point, dp[day][last]);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    //
    public static int ninjaTraining(int points[][], int lastDay, int day, int[][] dp) {
        if (dp[day][lastDay] != -1) {
            return dp[day][lastDay];
        }
        if (day == 0) {
            int maxMeritsZerothDay = 0;
            for (int i = 0; i < 3; i++) {
                if (i != lastDay) {
                    maxMeritsZerothDay = Math.max(maxMeritsZerothDay, points[0][i]);
                }
            }
            return maxMeritsZerothDay;
        }
        int maxMerit = Integer.MIN_VALUE;
        for (int merit = 0; merit < 3; merit++) {
            if (merit != lastDay) {
                int prevDayMerit = ninjaTraining(points, merit, day - 1, dp) + points[day][merit];
                maxMerit = Math.max(prevDayMerit, maxMerit);
            }
        }
        dp[day][lastDay] = maxMerit;
        return maxMerit;
    }


}

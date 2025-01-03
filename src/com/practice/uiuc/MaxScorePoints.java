package com.practice.uiuc;

public class MaxScorePoints {

    public static void main(String[] args) {
        MaxScorePoints obj = new MaxScorePoints();
        System.out.println(obj.maxScore(new int[]{1,2,3,4,5,6,7,8,9,10},4));
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int maxPoints = total;

        // Slide the window from the end of the array to the beginning
        for (int i = 0; i < k; i++) {
            total = total - cardPoints[k - 1 - i] + cardPoints[n - 1 - i] ;
            maxPoints = Math.max(maxPoints, total);
        }

        return maxPoints;
    }
}

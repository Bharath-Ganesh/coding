package com.leetcode.array;

/**
 * Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration seconds.
 * More formally, an attack at second t will mean Ashe is poisoned during the inclusive time interval [t, t + duration - 1]. If Teemo attacks again
 * before the poison effect ends, the timer for it is reset, and the poison effect will end duration seconds after the new attack.
 *
 * You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that Teemo attacks Ashe at second timeSeries[i], and an integer duration.
 *
 * Return the total number of seconds that Ashe is poisoned.
 *
 * Input: timeSeries = [1,4], duration = 2
 * Output: 4
 * Explanation: Teemo's attacks on Ashe go as follows:
 * - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
 * - At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
 * Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.
 */
public class _78_TeemoAttacking {

    public static void main(String[] args) {
        int[] timeSeries={1,4};
        int duration=2;
        System.out.println(findPoisonedDuration(timeSeries,duration));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {

        int count=duration;
        for(int i=1;i<timeSeries.length;i++){
            int diff=timeSeries[i]-timeSeries[i-1];
            if(diff>=duration){
                count+=duration;
            }else{
                count+=diff;
            }
        }
        return count;
    }
}

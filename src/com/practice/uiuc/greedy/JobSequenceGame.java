package com.practice.uiuc.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class JobSequenceGame {

    private ArrayList<Integer> JobScheduling(Job jobs[], int n) {
        // Your code here
        int[] profit = new int[n+1];
        Arrays.fill(profit, -1);

        Arrays.sort(jobs, new Comparator<>(){

            public int compare(Job job1, Job job2){
                return -1 * (job1.profit - job2.profit);
            }
        });


        for(int i=0; i<n; i++){
            int index = jobs[i].deadline;
            while(index>0){
                int maxProfit = jobs[i].profit;
                if(profit[index] == -1){
                    profit[index] = maxProfit;
                    break;
                }else{
                    index--;
                }
            }
        }



        Integer totalProfit = 0;
        Integer totalJobs = 0;
        for(int i=0; i<n+1; i++){
            if(profit[i]!=-1){
                totalProfit+=profit[i];
                totalJobs++;
            }
        }

        Comparator<Integer> comparator = (a1, a2) -> a1 - a2;

        ArrayList<Integer> result = (ArrayList<Integer>) Arrays.asList(new Integer[] { totalJobs, totalProfit });
        return result;
    }
}

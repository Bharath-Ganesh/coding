package com.leetcode.greedy;

import java.util.*;

/**
 * Job Sequencing Problem
 * https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
 */
public class JobSequencing {

    class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        JobSequencing obj = new JobSequencing();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        JobSequencing.Job[] arr = new JobSequencing.Job[n];
        int count = 0;
        int index = 0;
        scanner.nextLine();
        String items[] = scanner.nextLine().split(" ");
        while (n-- > 0) {
            int id = Integer.parseInt(items[count++]);
            int deadline = Integer.parseInt(items[count++]);
            int profit = Integer.parseInt(items[count++]);
            arr[index++] = obj.new Job(id, deadline, profit);
        }
        int[] res = obj.JobSchedulingS(arr, arr.length);
        System.out.println("Maximum profit : " + Arrays.toString(res));
    }

    int[] JobSchedulingS(Job arr[], int n)
    {
        // Your code here
        if(arr==null) return null;

        Comparator<Job> comparator=(j1,j2)->j2.profit-j1.profit;
        Arrays.sort(arr,comparator);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            Job job=arr[i];
            int deadline=job.deadline;
            int profit=job.profit;
            while(deadline>0){
                if(!map.containsKey(deadline)){
                    map.put(deadline,profit);
                    break;
                }
                deadline--;
            }
        }

        int num=0;
        int val=0;
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            num+=1;
            val+=m.getValue();
        }
        return new int[]{num,val};
    }

    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        Arrays.sort(arr, (o1, o2) -> o2.profit - o1.profit);
        int maxDeadLine = 0;
        for (int i = 0; i < arr.length; i++) {
            maxDeadLine = Math.max(maxDeadLine, arr[i].deadline);
        }

        int numberOfJobs = 0;
        int maxProfit = 0;
        int[] slots = new int[maxDeadLine];
        for (int i = 0; i < arr.length; i++) {
            int profit = arr[i].profit;
            int deadline = arr[i].deadline;
            if (isSlotsNotFilled(slots, deadline)) {
                numberOfJobs += 1;
                maxProfit += profit;
            }
        }
        return new int[]{numberOfJobs, maxProfit};
    }

    public boolean isSlotsNotFilled(int[] slots, int deadline) {
        for (int i = deadline - 1; i >= 0; i--) {
            if (slots[i] == 0) {
                slots[i] = 1;
                return true;
            }
        }
        return false;
    }
}

package com.practice.pepcoding.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 1. You are given two integers N and M, and an array(arr) of numbers with length M.
 * 2. N represents the total number of tasks assigned to a group of 5 students.
 * 3. Out of these five students, three students completed M number of tasks of their choices and left the group.
 * 4. Tasks completed by these students are represented by the given array.
 * 5. Now, the remaining two students(s1 and s2) have to complete all the remaining tasks.
 * 6. They decided to complete the remaining tasks in an alternate way -
 * First of the remaining tasks will be completed by s1
 * Second of the remaining tasks will be completed by s2
 * Third of the remaining tasks will be completed by s1.. and so on.
 * 7. You have to find the tasks that s1 and s2 have to complete.
 * <p>
 * int n=15;
 * int m=6;
 * int arr={2,3,5,6,8,11};
 */
public class TaskCompletion_36 {
    public static void main(String[] args) {
        int n = 15;
        int m = 6;
        int arr[] = {2, 3, 5, 6, 8, 11};
        taskCompletion(n,m,arr);
    }

    private static void taskCompletion(int n, int m, int[] arr) {
        int task[]= IntStream.range(1,n).toArray();
        for(int i=0;i<arr.length;i++){
            task[arr[i]-1]=-1;
        }
        boolean flag=true;
        List<Integer> p1=new ArrayList<>();
        List<Integer> p2=new ArrayList<>();
        for(int i=0;i<task.length;i++){
            int element=task[i];
            if(element==-1){
                continue;
            }
            if(flag){
                p1.add(element);
            }else{
                p2.add(element);
            }
            flag=!flag;
        }

        for(int num: p1){
            System.out.printf("%d ",num);
        }
        System.out.println();
        for(int num: p2){
            System.out.printf("%d ",num);
        }
    }
}

package com.practice.uiuc;

import java.util.Arrays;
import java.util.Comparator;

public class Trial {
    public static void main(String[] args) {
        check();
    }

    public static void check(){
       int[][] intervals= {{2,3}, {1,4}, {3,6}};
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        System.out.println(recursiveFibonacciNumber(8));


    }

    // 0 1 1 2 3 5 8 13 21

    public static int recursiveFibonacciNumber(int n){

        if(n == 0) return 0;
        if(n == 1) return 1;

        return recursiveFibonacciNumber(n-1) + recursiveFibonacciNumber(n-2);
    }
}

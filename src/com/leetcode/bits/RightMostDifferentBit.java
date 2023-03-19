package com.leetcode.bits;

public class RightMostDifferentBit {

    public static void main(String[] args) {
        System.out.println(posOfRightMostDiffBit(52, 4));
    }

    public static int posOfRightMostDiffBit(int m, int n) {
        int rmsb = Integer.MAX_VALUE;
        if(m==n){
            return -1;
        }
        // Your code here
        while (true) {
            int rmsbM = (m & -m);
            int rmsbN = (n & -n);

            if (rmsbM == 0) {
                return findMaxPowerOf2(rmsbN) + 1;
            } else if (rmsbN == 0) {
                return findMaxPowerOf2(rmsbM) + 1;
            }
            if (rmsbM == rmsbN) {
                m = (m & (m - 1));
                n = (n & (n - 1));
            } else {
                rmsb = Math.min(findMaxPowerOf2(rmsbM), findMaxPowerOf2(rmsbN)) + 1;
                break;
            }
        }
        return rmsb;
    }

    static int findMaxPowerOf2(int num) {
        int pow = 0;
        while (1 << pow <= num) {
            pow += 1;
        }
        return pow - 1;
    }
}

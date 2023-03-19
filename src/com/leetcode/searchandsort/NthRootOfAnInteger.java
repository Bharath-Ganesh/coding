package com.leetcode.searchandsort;

public class NthRootOfAnInteger {

    public static void main(String[] args) {

        System.out.println(findNthRootOfM(3, 27));
    }

    public static double findNthRootOfM(int n, int m) {
        // Write your code here.

        double low = 0;
        double high = m;
        double diff = 10e-7;

        while (high - low > diff) {
            double mid = low + (high - low) / 2.0;
            boolean isGreater = findPower(mid, n, m);
            if (isGreater) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }


    private static boolean findPower(double mid, int n, int m) {
        int min=2;
        Long.valueOf(min);
        double val = 1;
        for (int i = 0; i < n; i++) {
            val = mid * val;
            if (val > m) {
                return true;
            }
        }
        return false;
    }

//    private static double multiply(double number, int n) {
//        double ans = 1.0;
//        for (int i = 1; i <= n; i++) {
//            ans = ans * number;
//        }
//        return ans;
//    }
//
//    private static double getNthRoot(int n, int m) {
//        double low = 1;
//        double high = m;
//        double eps = 10e-7;
//
//        while ((high - low) > eps) {
//            double mid = (low + high) / 2.0;
//            if (multiply(mid, n) < m) {
//                low = mid;
//            } else {
//                high = mid;
//            }
//        }
//        return high;
//
//    }
//
//
    public static double findNthRootOfMC(int n, int m) {

        // Write your code here.
        double low = 1d;
        double high = m;
        double diff = 10e-7;
        while (high - low > diff) {
            double mid = ((low + high)) / 2.0;
            double val = findNum(mid, n);
            if (val >= m) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    private static double findNum(double mid, int n) {
        double val = 1d;
        for (int i = 0; i < n; i++) {
            val = val * mid;
        }
        return val;
    }
}
//}

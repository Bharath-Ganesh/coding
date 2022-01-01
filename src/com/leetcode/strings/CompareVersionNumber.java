package com.leetcode.strings;

/**
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumber {

    public static void main(String[] args) {
        CompareVersionNumber obj = new CompareVersionNumber();
        String version1 = "1.011";
        String version2 = "1.001";
        System.out.println(obj.compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();
        int i = 0, j = 0;
        while (i < n1 || j < n2) {
            int res1 = 0;
            int res2 = 0;
            while (i < n1 && version1.charAt(i) != '.') {
                res1 = res1 * 10 + version1.charAt(i) - '0';
                i++;
            }

            while (j < n2 && version2.charAt(j) != '.') {
                res2 = res2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            if (res1 > res2) return 1;
            if (res1 < res2) return -1;
            i++;
            j++;
        }
        return 0;
    }
}

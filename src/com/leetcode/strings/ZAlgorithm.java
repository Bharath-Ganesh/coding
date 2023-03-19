package com.leetcode.strings;

public class ZAlgorithm {

    public static void main(String[] args) {
//        String text = "aab";
//        String pattern = "xaabxcaabxaabxay";

        String text = "aabaabaadbaabe";
        String pattern = "aabaa";
        Integer val = null;
        callMethod(val);
        System.out.println(val);
        System.out.println(find(text, pattern));
    }

    private static void callMethod(Integer val) {
        val = 5;
    }


    public static int find(String text, String pattern) {

        // Create concatenated string "P$T"
        String concat = pattern + "$" + text;
        int count = 0;
        int l = concat.length();
        int Z[] = new int[l];

        // Construct Z array
        computeZArr(concat, Z);

        // now looping through Z array for matching condition
        for (int i = 0; i < l; ++i) {

            // if Z[i] (matched region) is equal to pattern
            // length we got the pattern

            if (Z[i] == pattern.length()) {
                count++;
            }
        }
        return count;
    }

    // Fills Z array for given string str[]
    private static void computeZArr(String str, int[] Z) {

        int n = str.length();
        // [left,right] make a window which matches with
        // prefix of s
        int left = 0, right = 0;
        for (int i = 1; i < n; ++i) {

            // if i>right nothing matches so we will calculate.
            // Z[i] using naive way.
            if (i > right) {

                left = right = i;


                while (right < n && str.charAt(right - left) == str.charAt(right))
                    right++;

                Z[i] = right - left;
                right--;

            } else {

                // k = i-left so k corresponds to number which
                // matches in [left,right] interval.
                int k = i - left;

                if (Z[k] + i <= right) {
                    Z[i] = Z[k];
                } else {


                    // else start from right and check manually
                    left = i;
                    while (right < n && str.charAt(right - left) == str.charAt(right)) {
                        right++;
                    }
                    Z[i] = right - left;
                    right--;
                }
            }
        }
    }
}

package com.leetcode.recursion;

import java.util.ArrayList;

/**
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
 * 2. You are standing in the top-left corner and have to reach the bottom-right corner.
 * 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more step
 * s vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).
 * <p>
 * 4. Complete the body of getMazePath function - without changing signature - to get the list of all path
 * s that can be used to move from top-left to bottom-right.
 * Use sample input and output to take idea about output.
 */
public class _021_GetMazeWithJumps {

    public static void main(String[] args) {
        String path = "";
        getMazePaths(0, 0, 2, 2, path);

    }

    public static void getMazePaths(int sr, int sc, int dr, int dc, String path) {

        if (sr > dr || sc > dc) {
            return;
        }
        if (sr == dr  && sc == dc ) {
            System.out.println(path);
            return;
        }

        for (int size = 1; size <= Math.max(dc, dr); size++) {
            getMazePaths(sr, sc + size, dr, dc, path + "h" + size);
            getMazePaths(sr + size, sc, dr, dc, path + "v" + size);
            getMazePaths(sr + size, sc + size, dr, dc, path + "d" + size);

        }
    }
}

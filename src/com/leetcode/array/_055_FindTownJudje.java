package com.leetcode.array;

/**
 * 997. Find the Town Judge
 * <p>
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
 * <p>
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 * <p>
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * <p>
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * <p>
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * <p>
 * [[1,3],[1,4],[2,3],[2,4],[4,3]]
 */
public class _055_FindTownJudje {

    public static void main(String[] args) {
        int trust[][] = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        int n = 4;
        System.out.println(findJudge(n, trust));

    }

    public static int findJudge(int n, int[][] trust) {

        int result[] = new int[n];
        for (int i = 0; i < trust.length; i++) {
            int normalPerson = trust[i][0];
            int potentialJudge = trust[i][1];
            result[normalPerson - 1]--;
            result[potentialJudge - 1]++;
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}

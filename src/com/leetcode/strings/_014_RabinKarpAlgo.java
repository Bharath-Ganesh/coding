package com.leetcode.strings;

/**
 * Rabin-Karp Algorithm for Pattern Searching
 * Given a text txt[0..n-1] and a pattern pat[0..m-1],
 * write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.
 */
public class _014_RabinKarpAlgo {


    public final static int PRIME = 3;

    /* Driver Code */
    public static void main(String[] args) {
        String txt = "abcedf";
        String pat = "def";
        search(pat, txt);
    }


    public static int search(String pat, String txt) {
        int n = pat.length();
        int m = txt.length();
        int pHash = calculateHash(pat, n);
        int tHash = calculateHash(txt, n);
        for (int i = 1; i <= m - n + 1; i++) {
            String substring = txt.substring(i - 1, i + n - 1);
            if (pHash == tHash) {
                //check if pattern are equal
                //return index;
                if (checkIfEqual(pat, txt.substring(i - 1, i + n - 1))) {
                    //i - 1;
                }
            }
            if (i < m - n + 1) {
                tHash = recalculateHash(txt, i - 1, i + n - 1, tHash, n);
            }
        }
        return -1;
    }

    private static boolean checkIfEqual(String pat, String substring) {
        if (pat.equals(substring)) {
            return true;
        }
        return false;
    }


    private static int calculateHash(String pat, int end) {
        int hash = 0;
        for (int i = 0; i < end; i++) {
            int ch = pat.charAt(i) - 'a';
            hash += ch * Math.pow(PRIME, i);
        }
        return hash;
    }

    private static int recalculateHash(String txt, int oldIndex, int newIndex, int tHash, int m) {
        int hashToBeDeleted = txt.charAt(oldIndex) - 'a';
        int newHash = tHash - hashToBeDeleted;
        newHash = newHash / PRIME;
        int hashToBeAdded = (txt.charAt(newIndex) - 'a');
        newHash += hashToBeAdded * Math.pow(PRIME, m - 1);
        return newHash;
    }


}

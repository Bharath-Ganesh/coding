package com.leetcode.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/description/
 */
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "ymain", endWord = "oecij";
        List<String> wordList = Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain");
        int length = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println(length);
    }

    class Pair {
        String word;
        int trans;

        public Pair(String word, int trans) {
            this.word = word;
            this.trans = trans;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        Pair p = new Pair(beginWord, 1);
        queue.add(p);
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        set.remove(beginWord);
        int ans = 0;
        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int trans = queue.peek().trans;
            queue.remove();
            if (word.equals(endWord)) {
                return trans;
            }
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    arr[i] = j;
                    String s = new String(arr);
                    if (set.contains(s)) {
                        queue.add(new Pair(s, trans + 1));
                        set.remove(s);
                    }
                }
                arr = word.toCharArray();
            }

        }
        return ans;
    }
}

package com.leetcode.graph;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> ladders = new WordLadder2().findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordLists) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : wordLists) {
            set.add(word);
        }
        set.remove(beginWord);
        Queue<List<String>> queue = new LinkedList<>();
        List<String> tempList = new ArrayList<>();
        tempList.add(beginWord);
        queue.add(tempList);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<String> usedWordLevel = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                List<String> wordList = queue.remove();
                int lastWord = wordList.size();
                String word = wordList.get(lastWord - 1);
                if (word.equals(endWord)) {
                    res.add(wordList);
                    continue;
                }
                List<String> queueList = new ArrayList(wordList);
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String s = new String(arr);
                        if (set.contains(s)) {
                            queueList.add(s);
                            queue.add(queueList);
                            usedWordLevel.add(s);
                        }
                    }
                    arr = word.toCharArray();
                }
            }
            for (int l = 0; l < usedWordLevel.size(); l++) {
                set.remove(usedWordLevel.get(l));
            }

        }
        return res;
    }
}

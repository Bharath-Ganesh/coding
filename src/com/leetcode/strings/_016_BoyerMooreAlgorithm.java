package com.leetcode.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class _016_BoyerMooreAlgorithm {

    public static void main(String[] args) {
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        StringBuilder pattern = new StringBuilder();
        Stream<Character> stream = set.stream();
        stream.forEach(x->pattern.append(x));
        System.out.println(pattern.toString());


    }
}

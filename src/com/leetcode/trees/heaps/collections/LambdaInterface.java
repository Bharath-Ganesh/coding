package com.leetcode.trees.heaps.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class LambdaInterface {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> stream = values.stream();
        Function<Integer, Integer> fn = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer value) {
                return value * value;
            }
        };
        Stream<Integer> squareStream = stream.map(fn);
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };
        Integer reduce = squareStream.reduce(0, binaryOperator);
        System.out.println(reduce);
    }


}

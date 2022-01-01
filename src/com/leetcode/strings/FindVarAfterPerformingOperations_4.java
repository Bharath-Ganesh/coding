package com.leetcode.strings;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 2011. Final Value of Variable After Performing Operations
 * There is a programming language with only four operations and one variable X:
 *
 * ++X and X++ increments the value of the variable X by 1.
 * --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 *
 * Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
 */
public class FindVarAfterPerformingOperations_4 {
    public static void main(String[] args) {
        String operations[] = {"--X","X++","X++"};
        int x=finalValueAfterOperations(operations);
        System.out.println(x);
    }

    public static Integer finalValueAfterOperations(String[] operations) {
        Integer X=0;
        for(String operation : operations){
           if( operation.contains("++")){
               X=evaluateExpression(true,X);
           }else {
               X=evaluateExpression(false,X);
           }

        }
        return X;
    }

    public static Integer  evaluateExpression(Boolean isPlus,Integer X){
        if(isPlus){
            X++;
        }else {
            X--;
        }
       return X;
    }


/**
 * If the return type is void, it won't affect the change
 */
//    public static void  evaluateExpression(Boolean isPlus,Integer X){
//        if(isPlus){
//            X++;
//        }else {
//            X--;
//        }
//        // return X;
//    }
}

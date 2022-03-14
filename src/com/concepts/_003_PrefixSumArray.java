package com.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array “A” of N integers and you have also defined the new array “B” as a concatenation of array “A” for an infinite number of times.
 * For example, if the given array “A” is [1,2,3] then, infinite array “B” is [1,2,3,1,2,3,1,2,3,.......].
 * Now you are given Q queries, each query consists of two integers “L“ and “R”.
 * Your task is to find the sum of the subarray from index “L” to “R” (both inclusive) in the infinite array “B” for each query.
 *
 * int[] arr={1 2 3};
 *
 */
public class _003_PrefixSumArray {

    public static void main(String[] args) {
        int[] arr={10};
        List<List<Long>> queries=Arrays.asList(Arrays.asList(1l,1l),Arrays.asList(7l,7l),Arrays.asList(3l,5l));
        System.out.println(sumInRanges(arr,queries));
    }

    public static List<Integer> sumInRanges(int[] arr, List<List<Long>> queries) {

        // Write your code here!
        List<Integer> result=new ArrayList();
        int[] prefix=new int[arr.length];
        prefix[0]=arr[0];
        for(int num=1;num<arr.length;num++){
            prefix[num]=prefix[num-1]+arr[num];
        }

        for(int q=0;q<queries.size();q++){
            long left=queries.get(q).get(0);
            long right=queries.get(q).get(1);
            long range=right-left+1;
            int quotient=(int) range/ arr.length;
            int rem=(int) range% arr.length;
            if(rem==0){
                result.add(quotient*prefix[prefix.length-1]);
            }else{
                result.add(quotient*prefix[prefix.length-1]+prefix[rem-1]);
            }
        }
        return result;


    }
}

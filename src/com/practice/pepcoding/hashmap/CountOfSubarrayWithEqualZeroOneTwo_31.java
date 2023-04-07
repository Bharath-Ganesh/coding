package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which consists of only 0s, 1s or 2s, count the number of substrings that have equal number of 0s, 1s and 2s.
 *
 * Integer arr[] = {1,1,2,0,1,0,1,2,1,2,2,0,1};
 * output
 */
public class CountOfSubarrayWithEqualZeroOneTwo_31 {
    public static void main(String[] args) {
        Integer arr[] = {1,1,2,0,1,0,1,2,1,2,2,0,1};
        int count=countOfSubarrayWithEqualZeroOneTwo(arr);
        System.out.println(count);
    }

    private static int countOfSubarrayWithEqualZeroOneTwo(Integer[] arr) {
        Integer count=0;

        int countZero=0;
        int countOne=0;
        int countTwo=0;

        Map<String,Integer> map= new HashMap<>();
        map.put("0#0",1);

        for(int i=0;i<arr.length;i++){
            String key="";
            if(arr[i]==0){
                countZero++;
            }else if (arr[i]==1){
                countOne++;
            }else{
                countTwo++;
            }
            key= (countOne-countZero)+ "#" +  (countTwo-countOne);
            if(map.containsKey(key)){
                count+=map.get(key);
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        return  count;
    }
}

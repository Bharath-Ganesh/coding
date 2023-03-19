package com.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequences2 {

    public static void main(String[] args) {
        DistinctSubsequences2 obj=new DistinctSubsequences2();
        String s="zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn";
        System.out.println(obj.distinctSubseqII(s));
    }


    public int distinctSubseqII(String s) {

        long mod = (long)1e9+7;
        int n=s.length();
        long[] dp=new long[n+1];
        dp[0]=1;

        Map<Character,Integer> map=new HashMap<>();
        for(int i=1;i<dp.length;i++){
            Character ch=s.charAt(i-1);
            dp[i]=((dp[i-1]%mod)*2)%mod;
            if(map.containsKey(ch)){
                int index=map.get(ch);
                dp[i]=(dp[i]-dp[index-1]);
                dp[i]%=mod;
            }
            map.put(ch,i);
        }
        return (int)((dp[n]-1)%mod);
    }
}

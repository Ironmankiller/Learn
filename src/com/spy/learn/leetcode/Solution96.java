package com.spy.learn.leetcode;

import java.util.Arrays;

public class Solution96 {

    public static void main(String[] args) {
        System.out.println(new Solution96().numTrees(50));
    }

    public long numTrees(int n) {

        if(n==0) {
            return 0;
        }

        long[] dp = new long[n+1];
        Arrays.fill(dp,0);
        dp[1]=1;
        dp[0]=1;

        for(int i=2;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];

    }
}

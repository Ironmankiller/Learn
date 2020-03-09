package com.spy.learn.leetcode;

import java.util.Arrays;

public class Solution62 {

    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths(12,10));
    }


    public int uniquePaths(int m, int n) {

        int[] dp = new int[m+1];
        Arrays.fill(dp,1);
        dp[0] = 0;

        for(int j=1;j<n;j++) {
            for(int i=1;i<=m;i++) {
                dp[i] = dp[i-1] + dp[i];
            }
        }
        return dp[m];
    }

//    public int uniquePaths(int m, int n) {
//        int[][] a = new int[n+1][m+1];
//        if(m==1 && n==1) {
//            return 1;
//        }
//        for(int i=1;i<=m;i++) {
//            for(int j=1;j<=n;j++) {
//                if(i==1||j==1) {
//                    a[j][i] = 1;
//                } else {
//                    a[j][i] = a[j-1][i] + a[j][i-1];
//                }
//            }
//        }
//        return a[n][m];
//    }
}
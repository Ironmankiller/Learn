package com.spy.learn.leetcode;

import java.util.Arrays;

public class Solution64 {

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new Solution64().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i=1;i<n;i++) {
            dp[i] = grid[0][i]+dp[i-1];
        }
        for(int i=1;i<m;i++) {
            dp[0] = grid[i][0] + dp[0];
            for(int j=1;j<n;j++) {
                if(dp[j]>dp[j-1]) {
                    dp[j] = dp[j-1] + grid[i][j];
                } else {
                    dp[j] += grid[i][j];
                }
            }
        }
        return dp[n-1];
    }

//    public int minPathSum(int[][] grid) {
//
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m+1][n+1];
//
//        for(int i=1;i<=m;i++) {
//            dp[i][1] = dp[i-1][1] + grid[i-1][0];
//        }
//        for(int j=1;j<=n;j++) {
//            dp[1][j] = dp[1][j-1] + grid[0][j-1];
//        }
//
//
//        for(int i=2;i<=m;i++) {
//            for(int j=2;j<=n;j++) {
//                if(dp[i][j-1] >= dp[i-1][j]) {
//                    dp[i][j] = dp[i-1][j] + grid[i-1][j-1];
//                } else {
//                    dp[i][j] = dp[i][j-1] + grid[i-1][j-1];
//                }
//            }
//        }
//        return dp[m][n];
//    }
}

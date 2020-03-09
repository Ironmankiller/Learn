package com.spy.learn.leetcode;

import java.util.Arrays;

public class Solution63 {

    public static void main(String[] args) {
        //System.out.println(new Solution62().uniquePaths(1,1));
        int[][] a= {
                {0,0,0,1,0,0,0},
                {0,0,0,0,0,1,0},
                {0,1,0,0,0,0,0}
        };
        System.out.println(new Solution63().uniquePathsWithObstacles(a));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;

        int[] dp = new int[m+1];
        Arrays.fill(dp,1);
        dp[0] = 0;
        for(int i=0;i<m;i++) {
            if(obstacleGrid[0][i] == 1){
                for(int j = i+1;j<=m;j++) {
                    dp[j] = 0;
                }
                break;
            }
        }
        for(int j=1;j<n;j++) {
            for(int i=1;i<=m;i++) {
                if(obstacleGrid[j][i-1] == 1) {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i-1] + dp[i];
                }
            }
        }
        return dp[m];
    }
}

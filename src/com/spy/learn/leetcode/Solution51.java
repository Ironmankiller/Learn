package com.spy.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution51 {

    public static void main(String[] args) {
        List<List<String>> lists = new Solution51().solveNQueens(8);
        for(List<String> list : lists) {
            for(String s: list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    boolean[] rows;
    boolean[] zhu;
    boolean[] cong;
    int N;
    int queens[];
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        N=n;
        queens = new int[n];
        rows = new boolean[n];
        zhu = new boolean[4*n+1];
        cong = new boolean[2*n+1];
        Arrays.fill(rows,true);
        Arrays.fill(zhu,true);
        Arrays.fill(cong,true);

        dfs(0);
        return result;
    }

    public boolean isVaild(int row,int col) {
        return rows[col]&&zhu[row-col+2*N]&&cong[row+col];
    }

    public void place(int row,int col) {
        queens[row]=col;
        rows[col] = false;
        zhu[row-col+2*N] = false;
        cong[row+col] = false;
    }

    public void addSolution() {
        List<String> list = new ArrayList<>();
        for(int row=0;row<N;row++) {
            StringBuilder sb = new StringBuilder();
            int col = queens[row];
            for(int i=0;i<N;i++) {
                if(i==col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        result.add(list);
    }

    public void delete(int row,int col) {
        queens[row]=0;
        rows[col] = true;
        zhu[row-col+2*N] = true;
        cong[row+col] = true;
    }

    public void dfs(int row) {
        for(int col = 0; col<N ;col++) {
            if(isVaild(row,col)) {
                place(row,col);
                if(row+1==N) {
                    addSolution();
                } else {
                    dfs(row+1);
                }
                delete(row,col);
            }
        }
    }

}


package com.spy.learn.leetcode;

import java.util.*;

public class Solution22 {

    public static void main(String[] args) {

        int n=3;
        List<String> ls = generateParenthesis(n);
        for(int i=0;i<ls.size();i++){
            System.out.println(ls.get(i));
        }
    }

//    public static List<String> generateParenthesis(int n) {
//
//        List<String> ls = new ArrayList<>();
//        if(n == 0){
//            return ls;
//        }
//
//        class Node {
//            private String str;
//            private int lres;
//            private int rres;
//
//            public Node(String str, int lres, int rres) {
//                this.str = str;
//                this.lres = lres;
//                this.rres = rres;
//            }
//        }
//
//        Node root = new Node("",n,n);
//        Queue<Node> q = new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            Node node = q.poll();
//            if(node.lres==0 && node.rres==0) {
//                ls.add(node.str);
//            }
//            if(node.lres != 0) {
//                q.offer(new Node(node.str+"(",node.lres-1,node.rres));
//            }
//            if(node.rres != 0 && node.rres>node.lres) {
//                q.offer(new Node(node.str+")",node.lres,node.rres-1));
//            }
//        }
//
//        return ls;
//    }

//    public static List<String> generateParenthesis(int n) {
//
//        if(n == 0){
//            List<String> ls = new ArrayList<>();
//            return ls;
//        }
//        List<List<String>> dp = new ArrayList<>(n);
//        List<String> dp0 = new ArrayList<>();
//        dp0.add("");
//        dp.add(dp0);
//
//        for(int i=1;i<=n;i++){
//            List<String> l = new ArrayList<>();
//            for(int j=0;j<i;j++){
//                List<String> list1 = dp.get(j);
//                List<String> list2 = dp.get(i-1-j);
//                for(String s1 : list1){
//                    for(String s2 : list2){
//                        StringBuilder sb = new StringBuilder();
//                        sb.append("(");
//                        sb.append(s1);
//                        sb.append(")");
//                        sb.append(s2);
//                        l.add(sb.toString());
//                    }
//                }
//
//            }
//            dp.add(l);
//        }
//
//        return dp.get(n);
//
//    }

//    public static List<String> generateParenthesis(int n) {
//
//        if(n == 0){
//            List<String> ls = new ArrayList<>();
//            return ls;
//        }
//        List<List<String>> dp = new ArrayList<>(n);
//        List<String> dp0 = new ArrayList<>();
//        dp0.add("");
//        dp.add(dp0);
//
//        for(int i=1;i<=n;i++){
//            List<String> l = new ArrayList<>();
//            for(int j=0;j<i;j++){
//                List<String> list1 = dp.get(j);
//                List<String> list2 = dp.get(i-1-j);
//                for(String s1 : list1){
//                    for(String s2 : list2){
//                        l.add("("+s1+")"+s2);
//                    }
//                }
//
//            }
//            dp.add(l);
//        }
//
//        return dp.get(n);
//
//    }

    public static List<String> generateParenthesis(int n) {

        List<String> ls = new ArrayList<>();
        if(n==0){
            return ls;
        }
        ls = dfs(n,0,0,new StringBuilder(),ls);
        return ls;

    }

    public static List<String> dfs(int n,int l,int r,StringBuilder sb,List<String> ls){

        if(r<=l&&r==n) {
            ls.add(sb.toString());
        }
        if(l<n) {
            dfs(n, l + 1, r, sb.append("("), ls);
        }
        if(r<l&&l>0&&r<n){
            dfs(n,l,r+1,sb.append(")"),ls);
        }
        if(sb.length()!=0)
            sb.deleteCharAt(sb.length()-1);
        return ls;
    }
}

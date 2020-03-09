package com.spy.learn.leetcode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numOfMinutes(7,6, new int[]{1,2,3,4,5,6,-1},new int[]{0,6,5,4,3,2,1}));
    }

    class Node{
        public int id;
        public int time;
        public Node(int i,int time){
            this.id = i;
            this.time = time;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int result=0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(headID,0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            List<Integer> ls = map.getOrDefault(manager[i],new ArrayList<Integer>());
            ls.add(i);
            map.put(manager[i],ls);
        }
        while(!q.isEmpty()) {
            Node x= q.poll();
            for(Integer i:map.getOrDefault(x.id,new ArrayList<>())){
                q.offer(new Node(i,x.time+informTime[x.id]));
            }

            if(x.time>result) {
                result = x.time;
            }
        }
        return result;
    }
}

package com.spy.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution93 {

    public static void main(String[] args) {
        List<String> l = new Solution93().restoreIpAddresses("25525511135");
        for(String s: l) {
            System.out.println(s);
        }
    }

    List<String> result;
    int len;
    String input;
    public List<String> restoreIpAddresses(String s) {
        len = s.length();
        input = s;
        result = new ArrayList<>();
        dfs(0,"",0);
        return result;
    }
    public void dfs(int part,String str,int res) {
        if(part == 4 && res==input.length()) {
            result.add(str.substring(0,str.length()-1));
            return;
        }
        if(part == 4) {
            return;
        }
        for(int i=res;i<3+res;i++) {
            if(i<input.length()) {
                if(i == res && input.charAt(i)=='0') {
                    dfs(part+1,str+"0.",res+1);
                    break;
                } else {
                    if(Integer.parseInt(input.substring(res,i+1))<=255) {
                        dfs(part + 1, str + input.substring(res, i + 1) + ".", i + 1);
                    }
                }
            }
        }


    }
}
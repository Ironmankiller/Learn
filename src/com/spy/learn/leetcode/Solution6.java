package com.spy.learn.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution6 {

    public static void main(String[] args) {
        System.out.println(new Solution6().convert("PAYPALISHIRING",3));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int part = 2*numRows-2;

        for(int i=0;i<numRows;i++) {
            for(int j=0; j+i<len;j+=part) {
                sb.append(s.charAt(j+i));
                if(i!=0 && i!=numRows-1 && j+part-i<len) {
                    sb.append(s.charAt(j+part-i));
                }
            }
        }
        return sb.toString();
    }
}

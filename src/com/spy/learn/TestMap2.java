package com.spy.learn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestMap2 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("sss");
        set.add("aaa");
        set.add("bbb");
        for(Iterator<String> iter = set.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

}

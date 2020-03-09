package com.spy.learn;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {

    public static void main(String[] args) {

        Map<Integer,String> m1 = new TreeMap<>();
        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");

        System.out.println(m1.size());

        System.out.println(m1.containsValue("three"));

        Map<Integer,String> m2 = new HashMap<>();
        m2.put(4,"四");
        m2.put(5,"五");

        m1.putAll(m2);
        System.out.println(m1);
    }
}

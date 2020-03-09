package com.spy.learn;

import java.util.Random;
import java.util.Scanner;

public class LearnRandom {

    public static void main(String[] args) {

        String str8 = "";
        long num1 = Runtime.getRuntime().freeMemory();
        long time1 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            str8=str8+i;
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("String占用的内存："+(num1-num2));
        System.out.println("String占用的时间："+(time2-time1));

        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10000;i++){
            sb.append(i);
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("String占用的内存："+(num3-num4));
        System.out.println("String占用的时间："+(time4-time3));
    }
}

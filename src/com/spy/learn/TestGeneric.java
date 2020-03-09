package com.spy.learn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class TestGeneric {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(list.size(),new Integer(i).toString());
        }
        for(String s:list) {

            System.out.println(s);
        }
    }
}

class MyCollection<T> {

    Object[] objects = new Object[5];

    public void set(T obj,int index) {
        objects[index] = obj;
    }

    public T get(int index) {
        return (T)objects[index];
    }
}
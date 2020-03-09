package com.spy.learn;

import java.io.*;

public class TestIO1 {

    public static void main(String[] args) {

        File file = new File("abc.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter out = null;
        try {
            out = new FileWriter(file);
            String s = "I'am your father.石鹏宇";
            out.write(s);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out!=null) {
                    out.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        FileReader in = null;
        try {
            in = new FileReader(file);
            char[] flush = new char[1024];
            int len;
            while((len=in.read(flush))!=-1){
                String s = new String(flush);
                System.out.println(s);
            }
            System.out.println();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(in!=null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

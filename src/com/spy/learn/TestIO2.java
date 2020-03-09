package com.spy.learn;

import java.io.*;

public class TestIO2 {

    public static void main(String[] args) {

        File file = new File("abc.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            String s = "I'am your father.";
            out.write(s.getBytes());
            out.flush();
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
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] flush = new byte[1024];
            int len = -1;
            while((len=in.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.print(str);
            }
            System.out.println();
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

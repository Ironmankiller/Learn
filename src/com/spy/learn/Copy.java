package com.spy.learn;

import java.io.*;

public class Copy {

    public static void main(String[] args) {
        copy("D:\\Black Mirror\\第二季\\Black.Mirror.S02E01.2013.1080p.WEB-DL.x265.AC3￡cXcY@FRDS.mkv","D:\\a.mkv");

    }
    public static void copy(String srcPath,String destPath){

        File file = new File(srcPath);
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream(destPath);
            byte[] flush = new byte[1024];
            int len = -1;
            while((len=in.read(flush))!=-1){
                out.write(flush,0,len);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

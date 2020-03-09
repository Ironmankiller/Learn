package com.spy.learn;

import java.io.File;

public class LearnArray {

    public static void findFile(File file,int level){

        for(int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File temp:files){
                findFile(temp,level+1);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
        File file = new File("e:/ArcSoft_ArcFace_Android_V3.0");
        findFile(file,0);
    }
}

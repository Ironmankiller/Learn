package com.spy.learn;

public class Main {
    static Main objMain = new Main();
    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                Main.method2();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                Main obj = new Main();
                obj.method();

            }
        }).start();
    }
    public static void method2() {
        synchronized (objMain) {

            System.out.println("method2......");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method2....666..");
        }
    }

    public void method(){
        synchronized (objMain) {
            System.out.println("method...");
        }
    }

}
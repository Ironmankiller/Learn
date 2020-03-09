package com.spy.learn;

import java.io.*;

public class DecorateTest {

    public static void main(String[] args) throws IOException,ClassNotFoundException {

        Person p = new Person();
        p.say();
        Amplifier amp = new Amplifier(p);
        amp.say();
        FileOutputStream out = new FileOutputStream("abc.txt");
        ObjectOutputStream o = new ObjectOutputStream(new BufferedOutputStream(out));
        o.writeObject(p);
        o.flush();
        FileInputStream in = new FileInputStream("abc.txt");
        ObjectInputStream i = new ObjectInputStream(new BufferedInputStream(in));
        Person p1 = (Person) i.readObject();
        p1.setVoice(1000);
        p1.say();
    }
}

interface Say{

    void say();
}
class Person implements Say,Serializable{

    private int voice = 10;

    @Override
    public void say() {
        System.out.println("人的声音为："+this.getVoice());
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

}
class Amplifier implements Say {

    private Person p;
    Amplifier(Person p) {
        this.p = p;
    }
    @Override
    public void say() {
        System.out.println("人的声音为："+p.getVoice()*100);
        System.out.println("噪音");
    }
}

package com.certifications.javase11.dataTypes;

class Singleton {

    private Singleton() {
    }

    private static Singleton instance;

    public static Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void greeting() {
        System.out.println("Hello");
    }

    public static void fun() {
        System.out.println("Fun");
    }

}

public class Test {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.greeting();
    }
}

package com.certifications.javase11.dataTypes;

class Demo {
    public static void display(){
        System.out.println("Hello this is a static method of Demo class");
    }
}
public class TestSample extends Demo {

    public static void display(){
        System.out.println("Hello this is a static method of TestSample class");
    }
    public static void main(String args[]) throws Exception{
        Demo demo = new Demo();
        Demo testSample = new TestSample();
        Demo testSample2 = new TestSample();

        demo.display();
        testSample.display();
        testSample2.display();
    }
}

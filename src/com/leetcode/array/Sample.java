package com.leetcode.array;


class InnerClass {

}

public class Sample {

    static int age;

    class StaticInnerClass {

    }

    static class StaticInnerClasses {
        String name;
        int age = 24;

        public StaticInnerClasses(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
//        Sample sample = new Sample();
//        InnerClass InnerClass = sample.new InnerClass();

        //I don't need an object or instance to call this class
        InnerClass InnerClass = new InnerClass();

        //cannot be referenced from a static context, because an object of sample is
        //required to call StaticInnerClass
        // StaticInnerClass staticInnerClass = new StaticInnerClass();

        StaticInnerClasses staticInnerClasses1 = new StaticInnerClasses("Bharath",25);
        StaticInnerClasses staticInnerClasses2= new StaticInnerClasses("Kunal",23);

        System.out.println(staticInnerClasses1.name);
        System.out.println(staticInnerClasses2.name);

    }
}

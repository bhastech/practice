package com.rajat.prac;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class Dog {
    public String name;
    public String breed;
    public int age;

    public Dog(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String toString()
    {
        return ("my name is" + this.getName() + "my breed is" + this.getBreed() + "my age is" + this.getAge());
    }

    public static void main(String[] args) {
        Dog tuffy=new Dog("tuffy","pom",4);
        System.out.println(tuffy.toString());
    }
}

interface p1 {
    default void show() {
        System.out.println("interface p1");
    }

}

interface p2 {
    default void show() {
        System.out.println("interface p2");

    }
}
class Test implements p1,p2
{
    @Override
    public void show() {
        p1.super.show();
        p2.super.show();

    }

}

public class Example{

    public static void main(String[] args) {

        Test e1 = new Test();
        e1.show();


        Set s  = new HashSet<>();
        s.add("Bhas");



        Map m = new HashMap();

        m.put("Bhas", new Object());
        m.put("Bhas", new Object());
        m.put("Bhas", new Object());
        m.put("Bhas", new Object());
        m.put("Bhas", new Object());


        System.out.println(m.size());


    }
}









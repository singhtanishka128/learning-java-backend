package com.telusko;

import java.beans.ConstructorProperties;

public class Alien {

    private int age;
    private Laptop lap;
    private int salary;

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        System.out.println("l setter called"); //called by ref attribute
        this.lap = lap;
    }

    public Alien(){
        System.out.println("alien constructor");
    }


    public int getAge() {
        return age;
    }

    @ConstructorProperties({"age", "lap", "salary"}) //here this should follow the sequence
    public Alien(int age, Laptop lap, int salary) {
        System.out.println("3 param const");
        this.age = age;
        this.lap = lap;
        this.salary = salary;
    }

    public void setAge(int age) {
        System.out.println("setter called");
        this.age = age;
    }

    public void code(){
        System.out.println("heyy");
        lap.compile();
    }
}

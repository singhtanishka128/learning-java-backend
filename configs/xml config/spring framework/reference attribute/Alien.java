package com.telusko;

public class Alien {

    private int age;
    private Laptop lap;

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        System.out.println("l setter called"); //Spring will call this setter automatically to inject the Laptop object slash called by ref attribute 
        this.lap = lap;
    }

    public Alien(){
        System.out.println("alien constructor");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setter called"); //called by value attribute
        this.age = age;
    }

    public void code(){
        System.out.println("heyy");
        lap.compile();
    }
}

package com.telusko;

public class Laptop implements Computer {

    public Laptop(){
        System.out.println("laptop obj created");
    }

    @Override
    public void compile(){
        System.out.println("Compiling using laptop");
    }
}

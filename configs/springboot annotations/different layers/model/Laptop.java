package com.kenny.app.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    public void Laptop(){
        System.out.println("laptop obj created");
    }

    public void compile(){
        System.out.println("Compiling using laptop");
    }
}

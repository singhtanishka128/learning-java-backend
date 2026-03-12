package com.kenny.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    private Computer com;
    private int age;

    public void Alien(){
        System.out.println("alien obj created");
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    @Qualifier("laptop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    @Value("25")
    public void setAge(int age) {
        this.age = age;
    }

    public void code(){
        System.out.println("heyy");
        com.compile();
    }
}

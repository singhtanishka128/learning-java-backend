package com.telusko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    private int age;

    //@Autowired
    //@Qualifier("com2")
    private Computer com;

    public Alien(){
        System.out.println("alien obj created");
    }

    //@Autowired
    public Alien(Computer com){
        this.com=com;
    }

    public int getAge() {
        return age;
    }

    @Value("22")
    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        System.out.println("heyy");
        com.compile();
    }
}

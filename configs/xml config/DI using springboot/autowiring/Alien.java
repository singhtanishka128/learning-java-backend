package com.kenny.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired //Find a Laptop bean and inject it here automatically
    Laptop laptop;
    
    public void code(){
        laptop.compile();
    }
}

package com.kenny.app;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{

    public void Desktop(){
        System.out.println("desktop obj created");
    }

    public void compile(){
        System.out.println("Compiling using desktop");
    }
}

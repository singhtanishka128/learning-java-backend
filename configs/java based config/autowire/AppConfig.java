package com.telusko.config;

import com.telusko.Alien;
import com.telusko.Computer;
import com.telusko.Desktop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean
    public Alien alien(@Autowired Computer com){
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setCom(com);
        return obj;
    }

}


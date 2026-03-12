package com.telusko.config;

import com.telusko.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    //@Bean(name = {"com2", "apple", "Beast", "desktop"})
    @Bean
    @Scope("prototype")
    public Desktop desktop(){
        return new Desktop();
    }
}

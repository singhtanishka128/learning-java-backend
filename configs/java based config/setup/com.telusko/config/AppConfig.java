package com.telusko.config;

import com.telusko.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    //@Bean(name = {"com2", "apple", "Beast", "desktop"})
    @Bean
    public Desktop desktop(){
        return new Desktop();
    }
}

package com.telusko;

import com.telusko.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop dt = context.getBean( Desktop.class);
        dt.compile();
        Desktop dt2 = context.getBean( Desktop.class);
        dt2.compile();
        
    }
}

// desktop obj created
// Compiling using desktop
// desktop obj created
// Compiling using desktop

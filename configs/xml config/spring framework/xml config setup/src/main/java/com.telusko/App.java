package com.telusko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //creates a container
        Alien obj = (Alien) context.getBean("alien"); // getBean will give you the object from the container.
        obj.code();
    }
}

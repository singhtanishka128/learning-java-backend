package com.telusko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); 

        Alien obj1 = (Alien) context.getBean("alien2"); 
        obj1.age=22;
        System.out.println(obj1.age);

        Alien obj2 = (Alien) context.getBean("alien2"); 
        System.out.println(obj2.age);

    }
}


//even if we are creating 2 references of object id alien2 only 1 object is created
// Why only 1 object is created?
// In Spring, beans are singleton by default.
// So when you write:
// Alien obj1 = (Alien) context.getBean("alien2");
// Alien obj2 = (Alien) context.getBean("alien2");
// Spring does not create two objects.
// It returns the same single object stored in the Spring container (IoC container).

// What happens step-by-step?
// ApplicationContext loads spring.xml.
// Spring creates one object of bean alien2.
// getBean("alien2") returns the same object every time.

// obj1.age = 22;
// System.out.println(obj1.age);  // 22
// System.out.println(obj2.age);  // 22

// Why?
// Because obj1 and obj2 point to the same object in memory.
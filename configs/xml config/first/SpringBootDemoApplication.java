//directory:
//SpringBootDemo->src->main->java->com.kenny.app-> 
// we get a default SpringBootDemoApplication
// whatever files we work with are located here. (inside com.kenny.app)

package com.kenny.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("hello world");
	}

}

/*
Springapplication.run activates your Spring framework.
It also has something called a container,
where you can create your Spring beans.
Spring is responsible to create the objects
and these objects are basically called beans.
So any object which is created/managed by Spring will be called beans.
just a normal object, different name.
Okay so this is how you run the container.
*/

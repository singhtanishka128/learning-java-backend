/*
this is just a documentation, i dont know how to git commit using intellij yet this is just some adhoc way of 
keeping records what im doing using vs code.
*/


/* 
old way creating object manually:
That's the only way you can call this code method
because this is a non-static method,
and if you want to call it, you need object. */

/* 
now i want spring to create objects, for that,
How Spring will know that you want to create the object?
spring creates the object inside container, 
So every time your Spring framework creates the object
for you, it'll be available in the container.
to get the object from the container we use application context.

in Springapplication.run, run method, returns the object
of configurable application context.
This configurable application context extends application context.
That means if you can simply use this run method return
value, you got the application context object.
run returns this object context giving us a way to communicate w ioc container.
so now instead of
Alien obj = new Alien();
we do
Alien obj = context.getBean(Alien.class);   //mentioning which class object we want //getBean = get the object

the IOC container will be able
to give you this object only if the object
is there in the container.

by adding the annotation @Component above the target class we let the 
Spring know that Spring has
to manage this particular object.
So create the object, assemble the object, and manage it.
Everything will be done by Spring just by this annotation.

So Spring is taking this object in the container
and it is also getting injected here
because we are saying getBean.

what if i have created another obj1 object of same class?
what if the alien method is dependent on some other class method?


*/

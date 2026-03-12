/*

structure : src -> main -> java -> com.telusko 

in spring framework there are 3 config approaches:
1. xml config
2. java based config
3. annotation based config

(we can always custom name our config file)
previously in xml we used xml file as the configLocation (spring.xml)
in java based config, we create a config folder/package under the main package (com.telusko)
inside config folder we create our config file (java class)again custom named eg: AppConfig

setup:

in main class (App.java), again ApplicationContext is the container which stores all the beans
Now instead of using the XML approach, 
we are going for a Java based approach.
For that we have to use a class
which is called AnnotationConfigApplicationContext,
And in this particular constructor
you have to pass the name of our config file,
which is AppConfig.class.

So, in both the cases, even if you're using XML,
even if you're using a Java based configuration,
you are basically using the same container,
but the way you talk to a container changes.

we use annotation @Configuration above the config class
So in the XML, we were using bean tag.
Here we are going to use the bean annotation.
we want objects/beans of Desktop.
we create objects for the classes we want but this object is 
injected, called and managed by spring
Now since this is a Java based configuration,
we have to manually create the object.

eg:
App.java:

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop dt = context.getBean( Desktop.class);
        dt.compile();

    }
}

config:

@Configuration
public class AppConfig {

    @Bean
    public Desktop desktop(){
        return new Desktop();
    }
}



Bean name:

by default, the method name becomes the bean name (desktop here)
so if we want to get the bean by name we pass it the context
eg:

App.java:

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop dt = context.getBean("desktop", Desktop.class);
        dt.compile();
    }
}

config:

@Configuration
public class AppConfig {

    @Bean
    public Desktop desktop(){
        return new Desktop();
    }
}

but what if we want to change it?
we add name attribute in the annotation @Bean and pass the same name as id in the context
eg:

App.java:

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop dt = context.getBean("com2", Desktop.class);
        dt.compile();

    }
}

config:

@Configuration
public class AppConfig {

    @Bean(name = "com2")
    public Desktop desktop(){
        return new Desktop();
    }
}

infact we can give multiple names to our bean. 
any one of them just needs to be matched by the passed name in the context.
eg:
App.java:

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Desktop dt = context.getBean("Beast", Desktop.class);
        dt.compile();

    }
}

config:

@Configuration
public class AppConfig {

    @Bean(name = {"com2", "apple", "Beast", "desktop"})
    public Desktop desktop(){
        return new Desktop();
    }
} */




/*SCOPE:

App.java:

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

desktop obj created
Compiling using desktop
Compiling using desktop

config:

@Configuration
public class AppConfig {

    @Bean(name = {"com2", "apple", "Beast", "desktop"})
    public Desktop desktop(){
        return new Desktop();
    }
}

by default the scope of all beans in the config is singleton
so even if we call object of same class multiple times,
only 1 object is created.

What if i want different objects of same class on multiple object calls?
basically how do we change the scope to prototype?
by adding @Scope annotation with value prototype
eg:

 @Bean
    @Scope("prototype")
    public Desktop desktop(){
        return new Desktop();
    }  */



/* AUTOWIRE:

how do we set the initial value of any property of a bean?
(suppose we are creating a bean for Alien class, it has 1 int property age, and a com variable 
of Computer class so this com is a dependncy here.)

we can use setters and getters to set the property value 
but i want the values to be assigned from the AppConfig so

 @Bean
    public Alien alien(){
        Alien obj = new Alien();
        obj.setAge(25);
        return obj;
    }

com is still null
how do i set the com variable which is an implementation of Computer class?
since Desktop is the implementation of Computer class
we pass the object of Desktop

@Bean
    public Alien alien(){
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setCom(desktop());
        return obj;
    }

since we are passing the Desktop object we are making the code tightly coupled
so we 

@Bean
    public Alien alien(@Autowired Computer com){
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setCom(com);
        return obj;
    }  
this @Autowired annotation is optional
*/




/*  PRIMARY AND QUALIFIER:

what if there are multiple implementations of Computer class, which one to give the preference?

how do i connect (in xml we used to connect by ref and id)?
we add @Qualifier annotation mentioning the name of preferred bean dependency
in the dependent bean (Alien) definition

config:

@Configuration
public class AppConfig {

    @Bean
    public Alien alien(@Qualifier("laptop") Computer com){
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setCom(com);
        return obj;
    }

    @Bean
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean
    public Laptop laptop(){
        return new Laptop();
    }

}

App.java:

package com.telusko;

import com.telusko.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Alien obj1 = context.getBean(Alien.class);
        System.out.println(obj1.getAge());
        obj1.code();

    }
}

laptop obj created
alien obj created
desktop obj created
25
heyy
Compiling using laptop

alternate: what if we dont want to mention @Qualifier?
we make the bean primary by adding @Primary annotation


@Configuration
public class AppConfig {

    @Bean
    public Alien alien( Computer com){
        Alien obj = new Alien();
        obj.setAge(25);
        obj.setCom(com);
        return obj;
    }

    @Bean
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean
    @Primary
    public Laptop laptop(){
        return new Laptop();
    }

}  */





/* COMPONENT STEREOTYPE ANNOTATION:

why do we use component stereotype annotation? 
we can use this in both java based config as well as the xml config.

Component stereotype annotations (like @Component, @Service, @Repository, @Controller)
are used to tell Spring that this class is a Spring bean so it can be automatically detected 
during component scanning and managed by the Spring container.

In short:
Marks a class as a Spring-managed bean.
Spring automatically creates and manages its object (no need to define it manually in config).

1. so instead of defining beans in the config file, we add @Component
annotation only above all the classes we want beans of. (doesnt imply on App.java, interface classes)

2. we add @ComponentScan("package") annotation mentioning all the packages containing @Compoonent classes above
the AppConfig class. this scans all the components, creates, manages and injects the bean automatically after detecting. */




/* Autowire Field, Constructor, Setter:

Alien class->
since we are using @Component annotation to create the beans, the spring asssigns
default values to the property of classes eg. int age = 0, 
and the dependency bean com remains null by default
to fix this we add @Autowired annotation above the dependency bean variable (com)

DEALING WITH DEPENDENCY BEAN VARIABLE (COM):

@Component
public class Alien {

    private int age;

    @Autowired
    private Computer com;

    public Alien(){
        System.out.println("alien obj created");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        System.out.println("heyy");
        com.compile();
    }
}

if we had only 1 / single implementation of Computer eg only Laptop and no Desktop then Desktop bean would have 
been assigned as the reference to com.

since we have multiple implementations of Computer interface,
we need to make any 1 bean primary or mention the bean name using @Qualifier annotation
(our bean name is the class name,
but make sure the first letter is small)
(in xml we used ref and id)

@Component
public class Alien {

    private int age;

    @Autowired
    @Qualifier("laptop")
    private Computer com;

    public Alien(){
        System.out.println("alien obj created");
    }

    etc etc 


if we want to change the bean name 
we can mention the bean name with the @Component annotation 

Desktop:

@Component("com2")
public class Desktop implements Computer{

    public Desktop(){
        System.out.println("desktop obj created");
    }

    @Override
    public void compile(){
        System.out.println("Compiling using desktop");
    }
}

Alien:

@Component
public class Alien {

    private int age;

    @Autowired
    @Qualifier("com2")
    private Computer com;

    public Alien(){
        System.out.println("alien obj created");
    }


if we dont want to use @Qualifier, we can use @primary above the preferrred bean

Laptop:

@Component
@Primary
public class Laptop implements Computer {

    public Laptop(){
        System.out.println("laptop obj created");
    }

    @Override
    public void compile(){
        System.out.println("Compiling using laptop");
    }
}

Alien:

@Component
public class Alien {

    private int age;

    @Autowired
    //@Qualifier("com2")
    private Computer com;

    public Alien(){
        System.out.println("alien obj created");
    }


So if we using @Autowired we are basically injecting the object, right.
So the injection can be done on three levels here.
1. field injection
2. constructor injection,
3. setter injection.


FIELD INJECTION:
-> if we are using @Autowired here

    @Autowired
    private Computer com;

it is a field injection because we are injecting the object directly to a field.


CONSTRUCTOR INEJCTION:
-> For constructor:
we can have a constructor which takes a parameter as com or a computer object
And then you can write autowired on top of it,
that becomes a constructor injection.

Alien:

@Component
public class Alien {

    private int age;

    //@Autowired
    //@Qualifier("com2")
    private Computer com;

    public Alien(){
        System.out.println("alien obj created");
    }

    @Autowired
    public Alien(Computer com){
        this.com=com;
    }

    public int getAge() {
        return age;
    }


Laptop:
    
@Component
@Primary
public class Laptop implements Computer {

    public Laptop(){
        System.out.println("laptop obj created");
    }


SETTER INJECTION:
ORRRRRRRRRRRRRR we can write @Autowired above our setter.

Alien:

@Component
public class Alien {

    private int age;

    //@Autowired
    //@Qualifier("com2")
    private Computer com;

    public Alien(){
        System.out.println("alien obj created");
    }

    //@Autowired
    public Alien(Computer com){
        this.com=com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        System.out.println("heyy");
        com.compile();
    }
}

Laptop:

@Component
@Primary
public class Laptop implements Computer {

    public Laptop(){
        System.out.println("laptop obj created");
    }

conclusion: It is always preferred to write autowired where you have your setter.

HOW DO WE SET VALUES TO PROPERTY USING @Component ?
by @Value annotation above the target variable,
notice we pass a string inside even if setting an integer value

@Component
public class Alien {

    @Value("21")
    private int age;

    @Value("Tanishka")
    private String name;
} */



/* what happens when we use both @Qualifier and @Primary ?
Qualifier gets the priority.  */ 


/*  SCOPE:
by default all the beans have a singleton scope
if we wanna change the scope, we add the @scope annotation above the target class
eg:

@Component("com2")
@Scope("prototype")
public class Desktop implements Computer{

    public Desktop(){
        System.out.println("desktop obj created");
    }  */
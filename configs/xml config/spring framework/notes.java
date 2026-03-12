/*

create a new maven project (catalog internal, archetype quickstart), (for springboot we use spring initializer from spring.start.io) 
build success in console remarks project structure is ready
we check our installed dependencies in the external libraries 
by default we get junit as dependency, we add spring context dep in pom.xml, reload. (this is a spring core project)

ApplicationContext(modern) and BeanFactory(depricated) both does the same thing -> helps getting the objects from container.
ApplicationContext -> acts as a container plus additional features
ApplicationContext is an interface, is a superset of BeanFactory

there are different ways of configuring spring project:
1. XML
2. java based
3. annotations

XML CONFIGURATION:

ApplicationContext context = new ClassPathXmlApplicationContext(); // creates a container
Alien obj = (Alien) context.getBean("alien"); // getBean will give you the object from the container.

getBean gives the object but we need to cast it into the type of object
since we are using a ClassPathXml application context,
it will look for the XML file in the class path.
In the class path, which is main, I have to create a folder - resources.
So it will basically look for the resource folder.
inside create xml file eg spring.xml. this is the configLocation we mention in

ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); 

we created this Spring container
and the configuration for that container
is mentioned in the spring.xml.
Now your Spring Framework knows
what are the classes, objects
this Spring has to create for you in the container
and it will happen on this line.

in spring.xml,
we create a bean tag -> beans are objects managed by spring framework
we mention 2 attributes in the tag -> id & class
id = name of the object 
class = classname along with package eg com.telusko.Alien

inside the tag (definition): 
we search for spring xml configuration (bean definition) on google official doc

<beans xmlns="http://www.springframework.org/schema/beans"    //bean definition
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="alien" class="com.telusko.Alien">  //created bean tag
    </bean>


</beans>

we create as many bean tags as the number of classes we have
the configuration will be done only once. therefore our core spring project is ready. */






/*
OBJECT CREATION:

object is crreated the moment spring.xml file is configured.
it means inside this xml file, create all the objects which are mentioned within the bean tag.
object of same class is created the number of times its bean tag is being defined.
giving the id of bean tag is optional but then it identifies the bean via different method.


what happens if we create 2 objects of same class having SAME ID?
only 1 object is created.

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

any Bean in the Spring has different scope.
we have different scope options.
Singleton, Prototype, Request, Session.
But in Spring Core we use only two,
which is Singleton and Prototype.
The others like Request and Session,
it works for web or web sockets.

So by default it follows Singleton,
which means in your application for this Alien,
there will be only one object created.
So it doesn't matter how many times you call them.
even if you say getBean, thousands of times
it'll refer to the same object.
It's because we created only one object here,
which is Alien1.

BUT WHAT IF i want 2 different objects belonging to same id?
for that we change the scope, how?
we add the scope attribute within  the bean tag

<bean id="alien1" class="com.telusko.Alien" scope="prototype">
</bean>

when the scope is Singleton (by default)
object is created/the container is loaded the moment the application is loaded
same object is summoned nevertheless how many times we access it via getBeans

But when the scope is Prototype,
the object will be created only when you say getBean.
So every time you say getBean, it'll create a new object.
So that is scope in Spring framework, we have two, Singleton and Prototype. */


/* 
SETTER INJECTION:

in spring framework, in order to assign a value to a PRIMITIVE variable we need to inject the value of property in the bean tag
this value is set via setter. therefore setter injection. 
when dealing with primitive variables, we use value attribute. */



/*
REFERENCE ATTRIBUTE:

in order to set a value of reference (object) we need the bean of another class,
and then we connect these 2 classes by adding a ref attribute with the same name as the id of bean of another class  
when dealing with objects, we use reference attribute.  */



/*
CONSTRUCTOR INJECTION:

we use getters and setters when we assign values later creating the obj, but when we wanna initialise the moment we create the object we
use parameterised constructors. 
in spring framework to set values of parameters of a const we use constructor-arg tag
if we dont mention the type, spring follows the sequence of value distribution
eg:
 <bean id="alien1" class="com.telusko.Alien" >
        <constructor-arg value="28"/>
        <constructor-arg ref="laptop"/>
 </bean>


 if we mention the type then it follows the type
 eg:
  <bean id="alien1" class="com.telusko.Alien" >
        <constructor-arg type="com.telusko.Laptop" ref="laptop"/>
        <constructor-arg type="int" value="28"/>
 </bean>


 but what if we have more than 1 same type like 2 int variables int age and int salary? then we use indexing.
 indexing starts from 0,
 eg:

 in Alien.java
  public Alien(int age, Laptop lap, int salary) {
        System.out.println("3 param const");
        this.age = age;
        this.lap = lap;
        this.salary = salary;
    }

in xml:
<bean id="alien1" class="com.telusko.Alien" >
        <constructor-arg index="1" ref="laptop"/>
        <constructor-arg index="2" value="28"/>
        <constructor-arg index="0" value="16"/>
</bean>


OR 


directly use the variable name as name attribute following the sequence
eg:
public Alien(int age, Laptop lap, int salary) {
        System.out.println("3 param const");
        this.age = age;
        this.lap = lap;
        this.salary = salary;
    }

<bean id="alien1" class="com.telusko.Alien" >
        <constructor-arg name="age" value="16"/>
        <constructor-arg name="lap"  ref="laptop"/>
        <constructor-arg name="salary" value="28"/>
</bean>



if we are using names and unbothered about following the sequence in xml then 
in Alien.java we use annotation @ConstructorProperties specifying the names in sequence
eg:

Alien.java:
    @ConstructorProperties({"age", "lap", "salary"}) //here this should follow the sequence
    public Alien(int age, Laptop lap, int salary) {
        System.out.println("3 param const");
        this.age = age;
        this.lap = lap;
        this.salary = salary;
    }

    spring.xml:
    <bean id="alien1" class="com.telusko.Alien" > //no sequence
        <constructor-arg name="lap"  ref="laptop"/>
        <constructor-arg name="age" value="16"/>
        <constructor-arg name="salary" value="28"/>
    </bean>  
    
    
conclusion:  famous one is indexing.
So if you want to have values which are compulsory,
you have to use constructor.
But if you have optional values, optional properties,
you can use setter injections.
So that depends upon the project requirement.  */




/*
AUTOWIRING:

if my ref attribute belongs to laptop object then laptop overrides the compile method
if it belongs to desktop then desktop overrides the compile method

 <bean id="alien1" class="com.telusko.Alien" >
        <property name="age" value="22"/>
        <property name="com" ref="desktop"/>
    </bean>

    <bean id="laptop" class="com.telusko.Laptop" >
    </bean>

    <bean id="desktop" class="com.telusko.Desktop" >
    </bean>

eg:

 <bean id="alien1" class="com.telusko.Alien" >
        <property name="age" value="22"/>
        <property name="com" ref="com"/> //id and ref matches
    </bean>

    <bean id="com" class="com.telusko.Laptop" > //laptop overrides
    </bean>


but if i dont want to connect it manually, it want it to be automatic whenever the id and ref name matches we do autowiring
by adding autowire="byName" attribute within the bean tag
eg:
 <bean id="alien1" class="com.telusko.Alien" autowire="byName">      (Computer com is the variable name)
        <property name="age" value="22"/>
    </bean>

    <bean id="comp" class="com.telusko.Laptop" >
    </bean>

    <bean id="com" class="com.telusko.Desktop" > //this matches therefore desktop overrides
    </bean>



if i add autowire attribute as well as mention the property explicitly then my property overrides. 
eg:
<bean id="alien1" class="com.telusko.Alien" autowire="byName">
        <property name="age" value="22"/>
        <property name="com" ref="comp"/>
    </bean>

    <bean id="comp" class="com.telusko.Laptop" > //laptop overrides
    </bean>

    <bean id="com" class="com.telusko.Desktop" >
    </bean>



if the autowire doesnt match with any id of any of the beans, we compare with type then
eg: 
case 1 -> when we have only 1 type matching
<bean id="alien1" class="com.telusko.Alien" autowire="byType">
        <property name="age" value="22"/>
        <property name="com" ref="comp"/>
    </bean>

    <bean id="comp" class="com.telusko.Laptop" >  //since laptop is a type of computer (laptop implements computer) this works
    </bean>
(same for desktop since desktop too implements computer)


case 2 -> when we have many multiple matching type then either go for autowire byName 

OR

we can add primary attribute in the bean tag (primary only works when we dont add the property matching name and ref)
eg:
<bean id="alien1" class="com.telusko.Alien" autowire="byType">
        <property name="age" value="22"/>
    </bean>

    <bean id="comp" class="com.telusko.Laptop" primary="true" > //laptop works
    </bean>

    <bean id="com2" class="com.telusko.Desktop" >
    </bean>


BUT if we mention the property again explicitly even after marking primary bean for autowiring byType,
property overrides. 
eg:
 <bean id="alien1" class="com.telusko.Alien" autowire="byType">
        <property name="age" value="22"/>
        <property name="com" ref="com2" />       //this
    </bean>

    <bean id="comp" class="com.telusko.Laptop" primary="true" >
    </bean>

    <bean id="com2" class="com.telusko.Desktop" >    //and this matches, so this outshines.
    </bean>  */




/*
LAZZYYYY initialization of bean:

we are working with three beans -> Alien , Desktop , Laptop
there are different varieties of scope for beans -> singleton & prototype,
whenever we don't mention the scope, by default, the scope is singleton,
which means in total you will get only one object.
when the container loads, it will load all the singleton objects.
since all these 3 beans have singleton scope by default,
the moment i run this application because of this line here, ClassPathXmlContext,
specifying spring.xml, in the application context,
it will basically load all the beans.
Even if you're not using it,
it will have the object ready for you.
(proof: even if i dont call any object, constructor of all the respective classes are being called)


what if i dont want the object to be loaded automatically, i want it to load only when i want it to load?
by adding lazy init attribute

eg:
 <bean id="com2" class="com.telusko.Desktop" lazy-init="true" >
</bean>

now if we call the object of desktop explictly then that object will be singleton.

Q) what happens if my non-lazy object is dependent on lazy object? (something non-lazy = eager)
The lazy bean will still be created at startup, because it becomes a dependency of the eager bean.
Spring must create the dependency first in order to create the eager bean, so the lazy bean gets initialized immediately.
A lazy bean becomes eager if it is a dependency of an eager bean.

Q) why do we make our beans lazy? 
We make beans lazy to delay their creation until they are actually needed.
This reduces startup time and saves memory/resources by avoiding unnecessary object creation.  */



/*
GetBean ByType:

in ApplicationContext we always typecast the object type into the class type of object we want 
eg:
Alien obj1 = (Alien) context.getBean("alien1");

Q) if we dont want to typecast? then we mention the class type in the argument
eg:
Desktop desk = context.getBean("com2", Desktop.class);

Q) when we dont want to mention id in bean tag?
we pass the classtype in context.getBean to identify the bean by matching classtype
eg:
main.java:
    Desktop desk = context.getBean(Desktop.class); 

xml:
    <bean class="com.telusko.Desktop" lazy-init="true" >
    </bean>


when we create reference obj of interface mentioning the subclass type. object gets created no error.
eg:
main.java:
Computer com = context.getBean(Desktop.class);

xml:
<bean  class="com.telusko.Desktop" lazy-init="true" >
</bean>

Q) what happens when there are multiple beans of same classtype when we are not mentioning id in context.getBean?
main.java:
    Computer com = context.getBean(Computer.class);


xml: <bean id="alien1" class="com.telusko.Alien" autowire="byType">
        <property name="age" value="22"/>
        <property name="com" ref="com"  />
    </bean>

    <bean id="com" class="com.telusko.Laptop" primary="true"  > //since this is made primary bean, laptop object gets created
    </bean>

    <bean  class="com.telusko.Desktop" lazy-init="true" >
    </bean>

Laptop bean (primary="true") is chosen when Spring needs a Computer bean.
The Desktop bean is not chosen.
Since Desktop is lazy-init="true", it won’t be created unless explicitly requested.

Q) what if we dont mention the primary bean as well?
in that case spring throws error since there are multiple beans of same classtype and spring doesnt know
which one to return when computer bean is asked.
Same type + no primary = Spring confusion → throws exception.
in such case, we should either specify the primary bean 
OR 
mention the beanid/name in both bean and context.
eg:

(mentioning beanId)
main.java:
        Computer com = context.getBean("com",Computer.class);

xml:
<bean id="alien1" class="com.telusko.Alien" autowire="byType">
        <property name="age" value="22"/>
        <property name="com" ref="com"  />
    </bean>

    <bean id="com" class="com.telusko.Laptop"   >
    </bean>

    <bean  class="com.telusko.Desktop" lazy-init="true" >
    </bean>


OR


(primary bean set)
main.java:
        Computer com = context.getBean(Computer.class);

xml:
  <bean id="alien1" class="com.telusko.Alien" autowire="byType">
        <property name="age" value="22"/>
        <property name="com" ref="com"  />
    </bean>

    <bean id="com" class="com.telusko.Laptop"   >
    </bean>

    <bean  class="com.telusko.Desktop" lazy-init="true" primary="true">
    </bean>  
*/




/* INNER BEAN:

here this laptop bean is a reference bean for the Computer interface
But that also means that this particular laptop bean
is available for the entire application.


<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="alien1" class="com.telusko.Alien" autowire="byType">
        <property name="age" value="22"/>
        <property name="com" ref="com"  />
    </bean>

    <bean id="com" class="com.telusko.Laptop"   > 
    </bean>

    
</beans>

What if I just want to limit this particular bean only for the alien?
we can do that by removing the ref attribute and
making this laptop bean an inner bean for the alien outer bean.
eg:

 <bean id="alien1" class="com.telusko.Alien" autowire="byType">
        <property name="age" value="22"/>
        <property name="com">
            <bean class="com.telusko.Laptop" >
            </bean>
        </property>
</bean>

*/
/* Learning Spring Boot:

Now we know how XML configuration and Java-based configuration work using a Spring Core project.

In Spring Boot, we usually don't write separate configuration files like XML
or explicit Java config classes. Instead, we use annotations and let Spring Boot
handle most of the configuration automatically.

The annotation @SpringBootApplication is used on the main class.
It is a combination of three important annotations:

1) @Configuration
   - Marks the class as a configuration class.
   - It tells Spring that this class can contain bean definitions.

2) @EnableAutoConfiguration
   - Spring Boot automatically configures the project based on the
     dependencies present in the classpath.
   - Example: If Spring Web dependency is present, it automatically
     configures a web server like Tomcat.

3) @ComponentScan
   - Spring scans the current package and its sub-packages
     to find classes annotated with:
       @Component
       @Service
       @Repository
       @Controller
   - These classes are automatically registered as beans
     in the Spring container.

So instead of manually configuring beans using XML or Java config,
Spring Boot automatically detects and manages them using annotations.

In short:
Spring Core → Manual configuration (XML / Java config)
Spring Boot → Auto configuration using @SpringBootApplication  */


/* note:
all the annotations which we used in a Spring core Project,
are also applicable in Spring Boot,
the biggest advantage you get here is
you don't have to do lot of configuration.
eg: using @Component, @Autowired, @Qualifier, @Primary, @Value,  */



/*  Different Layers:

In Spring applications, `@Component` is one of the stereotype annotations used to tell Spring to manage a class and create its object automatically as a bean. 
However, `@Component` is not the only stereotype annotation available. 
In a real-world application, especially in large systems like web applications, 
the architecture is usually divided into multiple layers to separate responsibilities and make the code organized and maintainable. 
Typically, an application consists of a Client, a Server, and a Database. 
The client sends a request to the server, the server processes the request, interacts with the database if needed, 
and then returns the response back to the client.

Inside the server itself, there are further logical layers. 
The first layer is the Controller, which is responsible for receiving requests from the client and sending responses back. 
The controller does not contain business logic; its role is only to handle incoming requests and delegate work to other layers. 
The next layer is the Service layer, which contains the business logic or processing logic of the application. 
Tasks such as performing calculations, applying rules, sorting data, or determining results are handled here. 
For example, calculating a factorial, adding numbers, finding the best stock to invest in, 
or sorting products based on ratings are typical responsibilities of the service layer.

However, the service layer usually does not interact directly with the database. 
Instead, there is another layer called the Repository layer (or DAO – Data Access Object). 
The repository layer is responsible for communicating with the database, fetching data, storing data, 
and returning the required information to the service layer. 
This separation ensures that each layer focuses on its specific role.

The overall flow of data in such an architecture is: 
the Client sends a request to the Controller, 
the Controller forwards the request to the Service, 
the Service requests data from the Repository, 
and the Repository interacts with the Database 
to retrieve the required information. 
The database then returns the data to the repository, which passes it to the service layer. 
The service layer processes the data if needed and sends the result back to the controller, 
and finally the controller returns the response to the client. 
This layered architecture helps maintain a clear separation of concerns and makes the application easier to manage, test, and scale.  */


/* Service layer:

So example, alien, laptop, desktop,
they actually represent some model,
the actual entity which you're going to store in database 
so we refactor them in model package.

suppose i wanna know if a laptop is good for programming
so we create a laptop bean and pass it in a method which does the checking
since its providing a service we organise our project by creating a separate
package for service and create a laptop service which provides all kinds of services 
relating to laptops.

LaptopService service = context.getBean(LaptopService.class);
this wont work if the LaptopService class doesnt have a @Component annotation 
@Component is not the only stereotype annotation option
@Service and @Component does the same 
(internally @Component annotation is itself added to the @Service definition)
using @Service instead of @Component is 
actually the better practice when the class belongs to the service layer.

in order to make connection of database with our project, we need jdbc  
we should always write jdbc code in repository class
where we will have all the database connections.
The only job of that class is to work with database.
(The job of service is to process the data,
or do some processing on some objects and something.)
in order to make the repo class work we add @Repository 
(we can also use @Component but why use it when you can use @Repository made for representing a repo layer)

so again we create a separate package for repo, create our repo class.

*/
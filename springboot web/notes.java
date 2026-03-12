//project structure: src->main->java->com.telusko->App, HelloServlet
/* Web Applications in Spring (Notes):

Spring is a framework that contains multiple projects, making it an umbrella for building different types of applications. 
One important area Spring focuses on is web application development. To build web applications, developers can use Spring Web. 
If Spring Boot is not used, developers can still build web applications using Spring MVC, which is part of the Spring framework.

Web applications are important because most modern systems operate on them. Even though mobile applications are widely used, 
almost every mobile app relies on a backend web application. The backend server handles requests from both web browsers and mobile applications, 
which means different clients can communicate with the same server.

On the client side, users see the frontend interface, such as a webpage or mobile app layout. 
Creating a static webpage using HTML and CSS is simple, but displaying dynamic content is more complex because 
each user may require different data. To generate dynamic content, a backend programming language such as Java is required.

When a client sends a request to the server, the server must accept the request, process it, and send a response back. 
In modern applications, the server usually sends data in JSON format, which can easily be used by frontend frameworks such as 
React, Angular, or Vanilla JavaScript, as well as by mobile applications.

The server may generate this data by retrieving information from a database or other external services. 
Similarly, the client can also send data to the server in JSON format, allowing two-way communication between the client and the server.

In Java, the traditional way to build such servers is by using servlets. 
Servlets are server-side components that handle client requests, process them, and send responses back. 
However, servlets cannot run directly on the JVM like normal Java programs. 
Instead, they require a special environment called a servlet container or web container.

A servlet container is responsible for managing servlets and handling web requests. 
One commonly used servlet container is Apache Tomcat, which is lightweight and widely used for running Java web applications.

Although Spring simplifies web development, it still uses servlets internally to handle HTTP requests and responses. 
Spring provides higher-level abstractions that make development easier while still relying on servlet technology behind the scenes.

There are two main approaches to building web applications in Spring: servlet-based programming and reactive programming. 
In most Spring applications, especially when using Spring MVC or Spring Boot, the servlet-based model is commonly used. 
Understanding servlets first helps developers understand how Spring handles web requests internally.
*/



/* connecting tomcat server:

we create a maven project, in pom.xml we add deps for jakarta servlet and tomcat embedded core, reload.
we create a new class for servlet which extends HttpServlet 
we need a method to access the request and response so we create a service method 
which takes 2 parameters - object/instance/reference of  
HttpServletRequest interface and HttpServletRequest interface
each for request and response respectively.
we print something to see if its working.

in our main class App.java, we create an object of Tomcat, we use start method and 
to keep the server running we use getServer and await.
we give a pathname hello
tomcat defaultly uses port 8080
we go to google search for localhost:8080/hello
but nothing works until i do servlet mapping.
in earlier days, we used xml eg: if this url is requested, use this servlet, etc
then we moved to annotations, we just have to add @webServlet ("/hello") mentioning method name
which means whenever the /hello URL is requested, this servlet should handle the request.
However, these annotations traditionally work when the application is deployed on an external Tomcat server. 
In that setup, developers manually download and run Tomcat separately, and then deploy the application to that server.

in a maven project, an embedded server can be added by including the server dependency (like tomcat) inside the pom.xml.
instead of installing and running an external tomcat server, the tomcat libraries are added directly to the project through maven. 
because of this, the server runs from inside the application.
so when the application starts, the embedded tomcat server also starts automatically and handles the requests.
for an embedded tomcat we have to do the mapping configuration manually. in springboot all these are implemented automatically bts.

we create a context object which takes 2 parameters- 
application name or the context for application (since we are working with the same application we use default which is "")
and
mention our directory (since we dont wanna cretea new dir structure we keep it null)

then we use addServlet a static method belonging to Tomcat class.
pass three parameters- the context, the name of a servlet, object.

        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "h1", new HelloServlet());
        context.addServletMappingDecoded("/hello", "h1");

the name of servlet should be same in both the addServlet and addServletMappingDecoded methods
after mapping we start the server.
run the application -> open localhost:8080/hello -> blank screen appears, tomcat server is running.
*/


/* rn on google engine i browse http://localhost:8080/hello, a blank screen appears
here my google engine is the client (application making the request), and 
localhost:8080/hello = the Server's address/URL
Server = Tomcat (running in IntelliJ) */


/* Responding to a client:

To send a response from a servlet, you work with the response object. 
By default, when a servlet runs, the client receives an empty response. 
To send actual data, you need to get a writer from the response object using getWriter(). 
Think of the response object as a piece of paper and getWriter() as taking a pen. 
Once you have the writer, you can use its print or println methods to send data. 
For example, response.getWriter().print("Hello World"); will send "Hello World" to the client. 
Since this can throw an IOException, you should handle it either with a try-catch or by adding throws IOException in the method signature.

res.getWriter().println("hello world");

Alternatively, you can store the writer in a variable, which makes the code cleaner:

PrintWriter out = res.getWriter();
out.println("Hello World");

This approach is similar to System.out.println, but instead of printing to the console, it writes to the response sent to the client. 
You can also include HTML tags in your output, like <h2> or <b>, but if you directly print them, the browser will display the tags as text. 
To render HTML correctly, set the content type of the response using 

res.setContentType("text/html"); 

This tells the browser to interpret the response as HTML, so your tags are rendered as design elements instead of plain text.
In this approach, the servlet handles three things: accepting the request, processing data (if needed), and returning the response. 
Returning a full HTML page directly from the servlet works for simple cases, but for complex designs, 
writing thousands of HTML tags inside Java code becomes messy and hard to debug. 
This is why the MVC (Model-View-Controller) pattern is used, separating logic from view for cleaner, maintainable code.

Finally, note that HTTP requests have different methods: GET, POST, PUT, DELETE, etc. 
By default, browser requests are GET. 
Use GET to retrieve data, POST to submit data, PUT to update, and DELETE to remove data. 

In servlets, doGet() handles GET requests, and doPost() handles POST requests. 
Since this example only retrieves data, doGet() is sufficient. 
Later, frameworks like Spring Boot will provide more advanced ways to handle these requests.
*/ 



/* Intro to Spring MVC (Model-View-Controller):

Web applications in Java can be created using Servlets. 
A web application essentially consists of a backend that accepts requests from the client, processes them, and then sends a response back. 
In most Java web applications, the backend is built using Java technologies, while the frontend is created using technologies like HTML, CSS, and JavaScript. 
Developers may also use frameworks such as React to build the frontend. In some cases, the client may not even be a browser; 
it could be a mobile application or another server requesting data. Regardless of the client type, the server’s role is to process requests and send data back.

When building web applications using Servlets, the servlet can directly send responses to the client. 
For example, the servlet can retrieve data from a database and return it as a response. 
However, if the client is a browser, simply sending raw data is not very useful or visually appealing. 
Users generally expect a structured and visually appealing interface, which is why frontend technologies are used to display the data properly.

In a traditional Servlet-based application, HTML content can be written directly inside Java code. 
However, this approach becomes problematic as the application grows. 
Mixing large amounts of HTML with Java code makes the program bulky, hard to read, and difficult to maintain. 
To solve this problem, Java introduced JSP (Java Server Pages).

JSP is a view technology that allows developers to write a complete HTML page and embed Java code within it wherever necessary. 
Instead of writing HTML inside Java code, developers write Java snippets inside an HTML structure. 
This makes the code much cleaner and easier to maintain. 
JSP is not the only view technology available in Java, but it is one of the commonly used ones for creating the view layer in traditional Java web applications.

multiple view technologies: options

Thymeleaf
FreeMarker
Groovy Markup
Script Views
JSP and JSTL

In such applications, Servlets and JSP work together. 
The servlet is responsible for accepting requests from the client and performing the required processing, 
such as communicating with the database or performing calculations. 
Once the processing is completed and the required data is obtained, the servlet forwards this data to a JSP page. 
The JSP page then uses that data to generate an HTML response and sends the final page back to the client.

Since Java is an object-oriented language, it is good practice to represent data using objects instead of simple variables. 
For example, if a client requests student data from the database, the application should store that data in an object, such as a Student class instance. 
This object-oriented representation of data helps maintain better structure and organization in the application.

This design approach leads to the MVC architecture pattern, which stands for Model–View–Controller. 
MVC is not specific to Java; it is a widely used design pattern for building web applications. 
In MVC architecture, the application is divided into three components.

The Controller handles incoming requests from the client. 
It decides what action should be performed based on the request. 
If the request requires data from a database, the controller interacts with the database and performs any necessary processing.

The Model represents the data of the application. 
It is typically implemented as a simple Java class that contains properties and methods related to the data. 
For example, a Student class that stores details like ID, name, and marks would act as a model. 
These simple Java classes are often called POJOs (Plain Old Java Objects).

The View is responsible for presenting the data to the client. 
It receives the model data from the controller and displays it in a user-friendly format, usually as an HTML page.

The flow of an MVC application works as follows: 
the client sends a request to the controller. 
The controller processes the request and retrieves or manipulates data using model objects. 
Once the data is ready, the controller passes the model object to the view technology. 
The view then uses this data to generate the final webpage and sends it back to the client.

In traditional Java web applications, this MVC structure is implemented using Servlets, JSP, and POJO classes. 
Servlets act as controllers because they handle incoming requests and coordinate processing. 
JSP pages act as views because they generate the HTML pages displayed to the user. 
Model objects are represented by simple Java classes (POJOs) that store application data.

Another important detail is how JSP works internally. 
Although developers write JSP pages using HTML and embedded Java code, the Tomcat server can only execute Servlets. 
Therefore, behind the scenes, every JSP page is automatically converted into a Servlet by the server. 
This generated servlet is then compiled and executed by the Tomcat Servlet container. 
As developers, we do not need to worry about this conversion process; 
we simply write JSP pages, and the server handles the transformation into servlets automatically.  */



/* creating a SpringBoot web project:

start.spring.io -> maven -> blabla -> choose packaging as jar (when you want to deploy your project on Tomcat,
we normally create a War file but choose jar rn) -> add dep -> spring web (this contains embedded apache tomcat so 
Springboard says we will be having a embedded Tomcat inside the project. That means when you run this project,
you already have a Tomcat there. And that's why we can run a packaging as Jar because we have a Tomcat installed inside the project) generate.
to check if its running start the project, surf localhost:8080 whitelabel error shows -> working.

spring will look for webapp folder for homepage so create webapp folder inside main
and inside webapp we create jsp file which would contain all the html with java snippets

hhow do we create a controller?
in our main application package com.smth.smthg we create a class HomeController, add @Controller annotation above class
See what happens behind the scene is it'll get converted
into Servlet and that's what works in the Tomcat.
Important things as a developer,
you don't have to create Servlets,
you just have to create a Controller and that's it.

we create a method (home) now this is responsible 
to call the index.jsp and return a view technology

when you run this project and send a request for the homepage,
Controller is called which further returns the String html for home method
from index.jsp, inorder to make this work we do mapping by adding @RequestMapping("/") above the target method
it means whenever / is called, perform this

run. localhost:8080/ a file gets downloaded which contains my jsp content.
this is because springBoot doesnot support jsp , we gotta convert jsp into servlet
so we add one more dep -> tomcat jasper (imp: version should be as same as the embedded tomcat)
after we update our pom.xml and rerun now this time we get out html rendered as we wanted.

*/
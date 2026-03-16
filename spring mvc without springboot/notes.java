/* 

project structure: src->main->java->com.telsuko->SpringMVCDemo

for building a web application using java,
in a springboot project we use embedded tomcat servers but when we use core spring mvc (w/o springboot)
we need an external tomcat server. since intellij community version doesnt support running external servers, we use Ecllipse ide
google apache tomcat download. get the zip, unzip it. we get java x or jakarta depending on the tomcat version

when we open eclipse, it asks for a workspace name, name anything, file -> create a maven project, catalog -> internal,
template -> webapp instead of quickstart because we buildind a web application
web app = spring mvc, groupid -> com.smth, artifact id - smth-> create. yes. enter.
in downloads, tomcat folder has bin which contains start and stop which runs my tomcat
we create a java folder inside src->main->java, add deps: spring mvc

In **Eclipse IDE**, a **Apache Tomcat** server must be configured before running a Spring web project. Inside the *Servers* tab, you add a new server by selecting Apache → the required Tomcat version (e.g., Tomcat v10.1). After choosing the server, you provide the installation directory where Tomcat is downloaded, or you can let Eclipse download it automatically. Once the path is set, Eclipse asks whether you want to attach any project to this server. Adding the Spring project ensures that Tomcat will run that project when the server starts.
After the server is created, Tomcat appears in the *Servers* tab in a stopped state. Starting the server launches Tomcat, but if the port (commonly **8080**) is already being used—such as by another running Tomcat instance in **IntelliJ IDEA**—the server will fail to start unless the port conflict is resolved by stopping the other instance or changing the port.
Once Tomcat runs successfully, the project can be deployed by right-clicking the project and selecting **Run As → Run on Server**, then choosing the configured Tomcat server. Eclipse deploys the application and opens a browser pointing to `localhost:8080`. If the page shows “resource is not available,” it means the server is running but the requested resource or mapping is not configured correctly in the project.

In a normal Spring MVC Maven project (without Spring Boot), simply creating controllers is not enough to run the application. Even if a controller such as `HomeController` exists with request mappings that return a view like `index.jsp`, the application may still show a **404 Not Found** error. This happens because the application is running on a servlet container like Tomcat, and Tomcat can only process requests through servlets. Since Tomcat does not automatically know about Spring controllers, it needs a servlet that can receive all incoming requests and route them to the appropriate controller.
In Spring MVC, this role is performed by the DispatcherServlet, which acts as the **Front Controller** of the framework. Instead of clients sending requests directly to different controllers, every request first goes to the DispatcherServlet. The DispatcherServlet then analyzes the request URL, determines which controller should handle it, and forwards the request to that controller. The controller processes the request and returns a response or view, which is then sent back to the client.
To enable this mechanism, the DispatcherServlet must be configured in the `web.xml` file of the project. This configuration connects Tomcat with Spring MVC. Inside `web.xml`, two main tags are used: `servlet` and `servlet-mapping`. The `servlet` tag defines the servlet class, which is `org.springframework.web.servlet.DispatcherServlet`, and assigns it a name. The `servlet-mapping` tag maps that servlet name to a URL pattern, typically `/`, meaning that all incoming requests should be handled by the DispatcherServlet. The servlet name in both tags must match so that the mapping works correctly.
Once this configuration is added, Tomcat sends every incoming request to the DispatcherServlet. The DispatcherServlet then identifies the correct controller based on the request mapping and forwards the request accordingly. This configuration is essential in traditional Spring MVC projects and usually needs to be done only once when setting up the application.

Configuring DispatcherServlet in Spring MVC (XML Configuration)
In a traditional Spring MVC project, the DispatcherServlet must be configured so it can locate controllers and handle requests properly. This configuration is done using an XML file called <servlet-name>-servlet.xml, which must be placed inside the /WEB-INF folder. The name of this file depends on the servlet name defined in web.xml. For example, if the servlet name is telusko, the configuration file must be telusko-servlet.xml.
Inside this XML file, Spring needs to know two things: which package to scan for components (controllers) and whether annotation-based configuration is used. Instead of manually mapping every request to methods in XML, Spring allows the use of annotations such as @Controller and @RequestMapping. To enable this, the XML configuration includes a component scan that tells Spring which package contains the controllers, and annotation-driven configuration so that annotations are recognized.

<ctx:component-scan base-package="com.telusko"/>
<mvc:annotation-driven/>

The component-scan instructs Spring to search the specified package for classes annotated with components such as controllers. The annotation-driven configuration enables Spring to process annotations for request mapping and controller handling.
After this configuration, the DispatcherServlet can successfully locate and execute the controller methods. However, another issue may appear when the controller returns a view name like "index". Spring understands that the controller method was called, but it does not know where to find the corresponding view file. This happens because the view resolver has not yet been configured. In Spring MVC, the view name returned by a controller must be translated into an actual file path using a view resolver, typically the InternalResourceViewResolver, which maps logical view names to JSP files.

Configuring View Resolver in Spring MVC (XML)
After configuring the DispatcherServlet, the controller methods may return a view name like "index". However, the server does not know where the view file is located or what its extension is. To solve this, Spring MVC uses a View Resolver that converts the logical view name returned by the controller into the actual JSP file path.
This is configured in the telusko-servlet.xml file using a bean. The class used is the InternalResourceViewResolver, which maps view names to JSP files.

<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/views/"/>
    <property name="suffix" value=".jsp"/>
</bean>

Explanation:
prefix → folder where JSP files are stored (/views/)
suffix → file extension of the view (.jsp)
When a controller returns "index", Spring resolves it as
/views/index.jsp.
JSP Expression Language Issue
Sometimes JSP does not display values returned from the controller because Expression Language (EL) is ignored. To fix this, add the following attribute in the JSP page:

<%@ page isELIgnored="false" %>

This ensures JSP processes expressions like ${data} or ${course} correctly.
Final Request Flow:
Client Request
→ Tomcat
→ DispatcherServlet
→ Controller Method
→ View Resolver converts "index" → /views/index.jsp
→ JSP renders response to the client.

summary: 

Spring MVC (without Spring Boot) – Quick Recap

A basic Spring MVC application starts as a Maven project where the Spring MVC dependency must be added. After adding the dependency, controllers can be created (for example HomeController) using annotations like @Controller and @RequestMapping to handle different requests.
However, since the application runs on a servlet container like Apache Tomcat, Tomcat does not automatically know that the project uses Spring MVC. Therefore, we must configure the DispatcherServlet in the web.xml file. The web.xml file is used to communicate with Tomcat and instructs it to send all incoming requests to the DispatcherServlet.
Once Tomcat forwards requests to the DispatcherServlet, it still needs configuration to locate controllers. This configuration is done using a file named <servlet-name>-servlet.xml (for example telusko-servlet.xml) inside the WEB-INF folder. In this file, component scanning is enabled to tell Spring which package contains the controllers, and annotation configuration is enabled so Spring can detect mappings defined through annotations.
When a controller method returns a view name such as "index", Spring does not know where that file exists. To resolve this, a View Resolver is configured using InternalResourceViewResolver. This resolver defines:
prefix → folder location of view files (e.g., /views/)
suffix → file extension (e.g., .jsp)
So when a controller returns "index", Spring converts it into /views/index.jsp and renders the page.
Overall request flow:

Client Request → Tomcat → DispatcherServlet → Controller → View Resolver → JSP View → Response.

In traditional Spring MVC, many configurations like servlet mapping, controller scanning, and view resolution must be done manually. This gives more control but requires more setup. Spring Boot simplifies this process by automatically configuring most of these components, which is why most modern projects prefer Spring Boot.
If your servlet name is telusko, what configuration file name does the DispatcherServlet look for by default? telusko-servlet.xml in WEB-INF
What two things must you typically declare in *-servlzet.xml so Spring can find annotation-based controllers? <ctx:component-scan>(base package) and <ctx:annotation-config>
check udemy mcqs for more
*/
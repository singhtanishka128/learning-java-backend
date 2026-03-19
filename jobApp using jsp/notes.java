/* 
spring.start.io initialised a springboot project from spring initializr, 
added deps like 
spring web (provides spring mvc architecture, embedded tomcat server, dispatcherServlet, basically web application environment )
lombok (to reduce the code), 
jasper (allows jsp files to run inside springboot), 
jsp, jstl (api and implemention both)(using as view technology) 

structure -> main -> java, resources, webapp
java -> com.telusko.JobApplication -> model,service,repo + other 2

in a controller, i return a string as jsp file which handles showing the UI
lombok dep gives inbuilt features we can use via annotations:
@Data - getters setters,
@NoArgsConstructor - default constructor with no parameter
@AllArgsConstructor - parameterised const with all parameters 
@Component - i want to use this class in other classes

instead of requestmapping, use postmapping (post method), getmapping (get method)
getmapping({"/", "home"}) means both these url return same page 

for accepting data we accept it in an object 
 @RequestMapping("handleForm")
    public String handleForm(JobPost jobPost){
        return "success";
    }

DTO = data transfer objects

home page shows, click on add job -> add job form shows we fill data, submit
someone has to catch this data and then show saved successfully so
handleForm accepts data and sends data to service
everything related to database should happen in repo layer whether we using array rn as a dummy db 
or later use some actual db so
passing data from controller to service, service to repo

removing jsp removes other deps too such as jsp jstl glassfish jasper (jsp is dependent on all these)
























































*/
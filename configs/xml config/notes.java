/* INTRODUCTION TO SPRING:

spring boot works on spring framework.
before spring we had ejb - jakarta enterprise beans
for web applications we had struts
for working with db with help of orm -> hibernate
combine altogether -> Spring.

Spring is a Lightweight Framework.
works with POJOs (plain old java objects)
used to build enterprise level applications.

prerequisites for spring framework -> java syntax, oops, exception handling, threads, collection API, jdbc, orm(hibernate), build tool (maven/gradle)
servlets. servlets were used earlier, we now use spring mvc, 
basically a higher-level framework built on top of Servlets.
Spring MVC does NOT replace Servlets.
It uses Servlets internally.
eg spring mvc works on some servers like Apache Tomcat,
Tomcat is servlet container.


IOC - Inversion Of Control & DI - Dependency Injection:

giving the control of object creation and flow of application/management to spring framework.
spring ioc takes the responsibility with the help of dependency injection design pattern used
to implement the ioc principle.
ioc is a principle, di is the design pattern.  */



/* ide:

we have options of
vs code
ecllipse
net beans
intellij idea

we are using intellij here, since there no spring support inbuilt
everytime we start a spring project we need to get the project structure from spring initializer
for a project, we create the structure only once.

SETTING SPRING STRUCTURE:

spring initializer ? go to start.spring.io website

select the build system (eg maven)
lang (java)
spring boot version (choose the one with no suffix , avoid snapshots, m1/m2, rc)
project metadata-> 
group name (com.kenny)
artifact (springbootdemo)
artifact and name might remain same, we may keep it different by choice, 
description comes automatic (can edit)
package name (com.kenny.app)
packaging (jar)
java versioning (17)
add dependencies if you want aand. generate.
open the zipped downloaded file, (extract all) unzip it browsing a location.
go to intellij -> open -> slect folder and done.  */
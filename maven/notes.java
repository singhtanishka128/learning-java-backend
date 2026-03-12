// maven is a project management tool.

// when we are building a project, we need to compile, run, test, package as well as deploy our files.
// hibernate is a framework or tool which helps you to save data in database without writing sql query. to work with it, we need to get a lot of libraries for hibernate, when we say library in java, we mean JAR files. how to get JAR files? 
// go to google, search for Hibernate JAR files, download and get it to the project (how do we get it? we’ll see that later)
// when working with jdbc and we want to  connect with MySQL, we need just 1 connector.
// when it comes to hibernate, we need multiple JAR files because the main dependency is a JAR file of hibernate which is itself dependent on other JAR files, we call them transitive dependencies.
// When building a Java project, you need external libraries called dependencies, which usually come as JAR files. Without a build tool, you would have to manually download these JAR files, add them to your project, and make sure their versions are compatible with each other. This becomes complicated when frameworks like Spring and Hibernate are used together, because certain versions may not work properly with others. If you upgrade one library, you might need to download everything again. It also creates problems in team environments, since every team member must manually download the exact same versions. If someone uses a different version, the project may fail to run.
// This is where Maven helps. Maven is a build automation and dependency management tool that allows you to simply declare the dependency name and version inside a `pom.xml` file. Maven then automatically downloads the required JAR files from a central repository and also fetches any additional dependencies needed by that library. It ensures that the correct versions are used and keeps everything consistent across machines, making collaboration easier. In addition to managing dependencies, Maven also provides a build lifecycle that supports tasks such as compiling, testing, packaging, installing, and deploying the project. Overall, Maven simplifies project management by automating dependency handling and the build process.
// suppose im using intellij ide and my friend is using ecllipse ide, some folders might hold a different name creating issue, but if i and my friend both choose  build system as maven then irrespective of ide, the project structure remains same.

// maven → mavenDemo → lifecycle → compile, test, package
// archtype → using existing templates , choose any or create your own.

// ### How to download dependencies in maven?
// ### perks of making our own library:

// POM = project object model.
// pom.xml is where we do everything to handle our maven
// every library goes in 3 things, GAV - Group id, Artifact id, Version id
// if im making my own library i wanna make sure this library is unique throughout the world, if i use a name theres a probability someone other in the world might have used the same name. so every project or every library will have a group id of its own depicting its uniqueness. this is like a package but make it unique.
// Group ID: In the entire world, domain names are unique, so if we reverse the domain, its unique as well thereby creating the group id (domain:  facebook.com → group id: com.facebook)
// Artifact ID: its the project name
// Version ID: the version

// ## how to add this dep code?

// let's say for your project, you or maybe in your company, you are going to create multiple project with the same type.
// So what you can do is you can create a template.
// In the world of maven , i need dependencies, i.e JAR files here example if i wanna connect my project to a MySQL database then we need a MySQL connector. to get that i can either:
// 1. go to google, search for mysqlconnector java , download it in the machine and get it to the project  OR
// 2. go to mvnrepository, search for mysql connector, choose version, get dependency code. now how to add this dep code?
// in pom.xml, just above the gav of our pom file, we create a  dependencies tag and paste the dep code we saw on mvnrepo page.
// whenever we add a dep code under dependencies tag we see a blue refresh, we click that to sync the jar files or simply go to maven panel and click on refresh/reload and we get the mysql connector. we see something mysql and another protobuf folder in external lib, now this (our jar file) mysql connector is dependent on the google protobuf (some other jar file which i didnt download),now this (protobuf) automatically added jar file is called a transitive dependency.
// eg we want to connect to hibernate as well, we go to mvnrepo we search for hibernate, choose version, copy dep code, add it in the deps tag (nothing happens until i reload), i reload, hibernate and its further deps appear on the external libraries.  

// Sending my file to someone new?

// i dont need to send them all the jar files, i’ll send them the pom file (pom.xml). they hit  the reload Maven, they get all the jar files in their machine.
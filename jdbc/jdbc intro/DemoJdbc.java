/*
jdbc stands for Java Database Connectivity
if we store data in varibles and close the application, we lose all the data
to store the data permanently we can either do it in a normal txt file, or store in a database
there are many disadvantages of using a txt file system so we use relational database management system
for a database, we need sql -> structured query language
the way the user can interact with a console based application is with the help of cmd
in java, we use jdbc connectivity to connect the application with the database
jdbc gives an API to connect with database
using postgresql rn
*/

//USING INTELLIJ HERE

/*
jdbc steps:
now we want to connect our java file to the postgres
step 1: once we got the jar file, we have to import the packages (phone)
step 2: load the driver (sim card)
step 3: register driver (network in the area)
step 4: create connection - connect application to database (connection established)
step 5: create statement (thinking about the statement)
step 6: execute statement (executing the statement and processing the response of my friend)
step 7: close connection (end the call)

bringing downloaded postgres to java file:

option 1-
google: search for postgres driver for jdbc, download, lastest java version download. open intellij go to file, project structure
libraries, plus button, java, select downloaded file from downloads, click on apply (bottom screen)
ok, done

option 2-
mvn repo: search for postgres jdbc choose version, click on jar 1.x mb 
*/


/*connecting postgres to java file:

//step1 import packages
import java.sql.*;      

//step2 load and register
Class.forName("org.postgresql.Driver"); (throws exception add that in try catch or main method) 

//step3 create connection
here Connection is an interface, not a class. to implement that we use -> DriverManager is a utility class, has a method called getConnection() this asks for 3 parameters -> url, user, password. this getConnection also throws exception so in the main method, we add the generic throws Exception (all errors to be caught under 1 Exception)
postgres, mysql all are network databases, they are available through network, so we have to mention our ip address and a port number


so we create 3 variables -> 
this username and password is for my dbms
for url -> java will be connecting to jdbc, jdbc will connect with db (mention postgresql if using postgres/oracle if using oracle/mysql if using mysql), then we mention the name of our database along with the ipAdress and portNumber
if db is in my local machine, ill mention local machine, if db lives on some other machine then after // we mention the ipAdress of that other machine
the default portnumber for postgres is 5432 and for mysql is 3306
con is the Connection object

String url = "jdbc:db://localhostORipaddress/dbName";
String uname = "db(postgres/mysql/oracle)";
String pass = "password of db";
Connection con = DriverManager.getConnection(url, uname, pass);
*/
 



// import java.sql.*;                                                                //step1 import package

// public class DemoJdbc {
//     public static void main(String[] args) throws Exception {

//         /*
//         steps:
//         import package
//         load and register
//         create connection
//         create statement
//         execute statement
//         process the results
//         close
//          */

//         String url = "jdbc:postgresql://localhost:5432/demo";
//         String uname = "postgres";
//         String pass = "Tanishka$28";

//         //Class.forName("org.postgresql.Driver");   //this is optional         //step2 load and register
//         Connection con = DriverManager.getConnection(url, uname, pass);        //step3 create connection 

//         System.out.println("Connection Established");
//     }
// }

//3 steps done till here


/*
to fetch data from postgres: query tool -> select sname from student where sid = 1;
to fetch data using java:

String sql = write query
Statement st = con.createStatement(); //step4 creates statement

ResultSet rs = st.executeQuery(sql); //step5 storing the response in resultset, resultset is an interface
//step6 executing the statement

rs.next(); //returns boolean value if a row exists, return true else return false, also moves the pointer to the next row
*/



// import java.sql.*;      //step1 import package
// public class DemoJdbc {
//     public static void main(String[] args) throws Exception {

//         /*
//         steps:
//         import package
//         load and register
//         create connection
//         create statement
//         execute statement
//         process the results
//         close
//          */

//         String url = "jdbc:postgresql://localhost:5432/demo";
//         String uname = "postgres";
//         String pass = "Tanishka$28";
//         String sql = "select sname from student where sid = 1" ;

//         //Class.forName("org.postgresql.Driver"); //step2 load and register
//         Connection con = DriverManager.getConnection(url, uname, pass);  //step3 create connection
//         System.out.println("Connection Established");
//         Statement st = con.createStatement();  // step4 create statement
//         ResultSet rs = st.executeQuery(sql); //step5 execute statement
//         System.out.println(rs.next()); //step6 response processing
//         con.close();
//         System.out.println("Connection closed");
//     }
// }

//allsteps done







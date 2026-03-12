/*  Spring JDBC – 

To store data, we use databases.
To connect a Java application with a database, we use Java Database Connectivity (jdbc).
However, using normal JDBC requires several manual steps such as 
loading the driver, establishing a connection, creating statements, executing queries, processing results, and closing the connection. 
These steps increase the amount of boilerplate code and require the programmer to manage resources manually.
To simplify this process, the Spring JDBC module is used. 
It reduces the complexity of database operations and provides components that handle many low-level tasks automatically. 
One of the most important components is JdbcTemplate, which helps 
execute SQL queries, manage database connections, process results, and handle exceptions with minimal code.
Spring JDBC also works with DataSource, which manages database connections efficiently. 
Instead of creating a new connection for every request, 
DataSource can reuse existing connections through connection pooling, improving application performance.
Since JDBC only defines standards, the actual implementation is provided by database-specific drivers. 
Different DBMS like PostgreSQL, MySQL, Oracle Database, and Microsoft SQL Server provide their own JDBC drivers.
In this module, the database used is H2 Database, which is an in-memory database. 
It allows developers to quickly create and test databases during development. 
However, since it stores data in memory, all data is lost once the application is closed. 
Adding the H2 dependency automatically provides the required JDBC driver as well.  */


/* gist :
so we are trying to create a project which manages students record in 
database. we organise the project structure using layers.
create Student class, create properties like roll, name, marks, implement getters-setters
create student object, set values. 
StudentService class provides all the students service.
StudentRepo handles all the operations including database.
give proper annotations.
(in order to use a method from different class i need the object of that different class to call that method
so we keep that dependency object/bean as a variable, create getter-setter, do the autowiring)
*/



/* jdbc setup:

in repo class/dao we create a custom named variable of type JdbcTemplate
eg: private JdbcTemplate jdbc; 
implement getter-setters and above setter we add @Autowired, spring automatically provides/injects the dependency required
in jdbc if we want to execute a query, we have 2 options.
when we want to update data like 
inserting, updating, deleting, we use executeUpdate.
And when you want to file a select query, we use executeQuery.
update() -> executeUpdate() bts
in repo class, inside each method we write query, 
in update() we pass query and all column values in sequence we passed in query
.update() returns an int value -> returns 0 if no operations done else returns number of ops done
eg:

    public void save(Student s){
        
        String sql = "insert into student (rollno, name, marks) values (?,?,?)";
        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println( rows + "effected");

    }



how do we create schemas?
in resources folder, we create 2 files- schema.sql and data.sql
in schema, we create tables and mention properties of that class as column names along with datatype
eg:
create table student (
    rollno int primary key,
    name varchar(50),  //size capacity of name
    marks int
);

we want 3 student records already preloaded in the database so
in data.sql,
insert into student (rollno, name, marks) values (23, 'Sarah', 96);
insert into student (rollno, name, marks) values (21, 'Kavya', 94);
insert into student (rollno, name, marks) values (42, 'Arya', 92);


how do we fetch data from db?

 public List<Student> findAll() {
        String sql = "select * from student";
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {  //we are getting the data from the resultset and setting it into an object to return it
                Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));

                return s;
            }
        };

        return jdbc.query(sql, mapper);
        
    }

To fetch data that we store in the database using Spring JDBC, we can use a query with the JdbcTemplate. 
First, define the SQL query as a string, for example, "select * from student". 
To execute this query, we use the query method of JdbcTemplate, which takes two parameters: the SQL query string and a RowMapper object. 
The RowMapper is responsible for mapping each row of the ResultSet returned by the query into a Java object. 
Whenever a select query is executed in JDBC, a ResultSet is returned, and the RowMapper helps extract one row at a time from it.

RowMapper is an interface, specifically a functional interface, 
which means we can implement it using either an anonymous class or a Lambda expression. 
Its main method is mapRow, which takes two parameters: a ResultSet representing the current row and a row number. 
Within mapRow, we can extract data from the ResultSet using methods like getInt or getString, specifying either the column name or column index. 
Typically, we create a new object—for example, a Student object—and set its fields with the values fetched from the ResultSet. 
After populating the object, we return it from the mapRow method.

The query method then collects all these objects into a list and returns it. 
This approach is more concise and readable compared to traditional JDBC code. 
Additionally, since RowMapper is a functional interface, the anonymous class implementation can be replaced with a Lambda expression, 
further shortening the code. Using a Lambda, we can directly fetch the data from the ResultSet and return the object in a single, compact expression. 
This makes the code cleaner, reduces boilerplate, and leverages Java’s functional programming features while interacting with the database via Spring JDBC.

JdbcTemplate + RowMapper = ResultSet → Object → List; use Lambda to shrink lines.

lambda exp:

    public List<Student> findAll() {
        String sql = "select * from student";
        return jdbc.query(sql, (rs, rowNum) -> {
                Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
        });
    }

project structure:
src -> main -> java -> com.kenny.springJdbcEx, resources

uptill this we have used H2 embedded (in memory database)
H2 is a lightweight, Java-based relational database that can run in-memory for super-fast, temporary use or file-based for persistence. 
It supports standard SQL and integrates seamlessly with Spring Boot—just add the dependency. 
H2 also provides a handy web console (/h2-console) to browse tables and run queries. 
Often used for development or testing, it’s plug-and-play, requires minimal setup, and pairs with HikariCP for fast, 
managed database connections.

HikariCP is the default connection pool used with H2 (and other databases) in Spring Boot.
It manages database connections efficiently, so your app doesn’t open a new connection every time—it reuses them.
*/




//h2 was an in memory, embedded all db connection/setup automatically done by springboot typeof db
/* what if we wanna use an external database?  

we only need to change 2  files - pom.xml, application.properties
in pom.xml -> we remove the h2 dependency
search for postgresql jdbc driver in mvnrepo, select a version, copy maven dep code, paste in pom.xml, reload. (postgres added)
in application.properties we add 4 urls 

spring.datasource.url=jdbc:postgresql://localhost:5432/telusko  
spring.datasource.username=postgres  (username we set at the initial setting of postgres in machine)
spring.datasource.password=password  (postgres setup password w/o any quotes)
spring.datasource.driver-class-name=org.postgresql.Driver   (different for different databases) done.

(url)->
jdbc:postgresql://localhost:5432/telusko
│      │          │        │    │
│      │          │        │    └── database name
│      │          │        └──── port
│      │          └───────────── host/ip address
│      └──────────────────────── database type
└─────────────────────────────── JDBC protocol

*/




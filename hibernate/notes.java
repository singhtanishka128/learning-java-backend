//DISCLAIMER:

/*  JDBC is enough to build applications.
But it requires a lot of boilerplate code (connections, statements, queries, result mapping, closing resources).
To improve:, Productivity, Code quality, Maintainability
We use frameworks.

Why Spring? Spring Framework reduces manual work and makes building applications faster and cleaner.
Why Hibernate? Hibernate is an ORM tool.

{ { {  sneak peek of ORMs:  ORM = Object Relational Mapping.

Object → Java objects (classes, fields, getters, setters… OOP world)
Relational → Database tables (rows, columns, relations)
Mapping → Connecting both worlds automatically

What it actually means
In Java:

class Student {
   int id;
   String name;
}

In database:

Table: student
id | name

ORM converts this Java object into a database row and vice versa.
You don’t manually write heavy SQL to map every field.
The ORM tool handles the translation.

Example of ORM Tool : Hibernate
It converts:
Java object ➝ SQL insert/update
SQL result ➝ Java object
Automatically.

Why it exists? Because:
Java = Object-Oriented
Database = Relational
They speak different languages
ORM = translator between two worlds. 

} } }

Instead of: Writing SQL, Manually mapping database tables (relations) to Java objects

Hibernate:
Automatically maps Java objects ↔ database tables
Reduces SQL writing
Handles CRUD operations for you

What About Spring Data JPA? Inside Spring, there’s Spring Data JPA.
It:
Builds on ORM concepts
Lets you perform database operations with minimal or no SQL
Further boosts productivity
In One Line
JDBC = manual work
Hibernate = automatic object-table mapping (ORM)
Spring Data JPA = even higher-level abstraction
We move from raw control → smarter tools → faster development. */


/* how an orm like hibernate works? 

(spring data jpa also uses hibernate internally)
Hibernate is an ORM framework,
what is ORM? ORM stands for Object Relational Mapping.
why do we need it?
Java is an object oriented language. Everything in that is object, And when you build an application with Java, the first thing which comes to your mind is object. 
Whatever you wanna do, it should be an object. if you want to build an application, every entity you want to represent a person or a thing it should be an object
then we start planning what operations I can perform with the provided yet.
So every object will have its own data and methods.
to store this data, we want a permanent storage, not in a memory.
permanent storage can be a CSV file or any other type of file.

But if you want to store data which can be processed simultaneously, we need databases.
can be a relational one, can be a non-relational one, (NoSQL databases)

in case of a relational database, 
In JDBC, we can use Oracle, Postgres, MySQL, etc And if you want to store this data, we have to use SQL.
in JDBC, if you want to store the data of the object in the database, we have to write sql queries doing all crud operations

eg: if you want to insert/create data, we'll use query = "insert into table values(bla, bla, bla)" ,
Now since this data is stored in the variables
of the object, you have to manually fetch them,
put them in that query, and then execute. Tedious task.

So the first problem is as a Java developer, we always think about object.
Then we have to understand SQL as well.
And of course you should know SQL,
but do we have to master it?
Do we have to remember all the queries?
what about the optimization? What about the caching?
that requires a lot of steps if we use jdbc doing all that
this is where Hibernate comes into picture
orm takes the object and puts that in database

orm does that with the help of a blueprint of the object which is a class.

example:
Student class -> has 3 variables (roll number, name and age) -> we create the object of student class

Now someone as a viewer, wants a table to store this data
we will be needing table name, number of columns he wants, name of the columns, data-type of columns, how will i be representing those data in a row aka mapping?

using hibernate,

classname becomes table name
number of variables becomes number of columns
datatype of variables becomes datatype of columns
Every object have different data.
So each object becomes one row.
in Java we use camel casing, here we'll be using snake casing.


hibernate also provides us different features.
helps us with the productivity.
easier to maintain the Hibernate codes (everything is abstracted)
we don't have to write the SQL queries.
easier to switch into different databases.
And most important is the performance.
The caching, optimization works smooth with Hibernate. */



/*  HOW DO WE IMPLEMENT HIBERNATE?

we can also convert the existing jdbc project into a hibernate application. 
how do we start a fresh hibernate project?
open intellij, new project, name the project, maven build system (we can also use gradle), create
now we convert this maven projext into a hibernate project. open Main.java, delete the pre-written code for org.example, rename org.example to something like com.kenny
something like this:


// package com.kenny;

// public class Main {
//     public static void main(String[] args) {

//     }
// }

now we open pom.xml, add 2 dependencies in the dependencies tag
1 for hibernate and 1 for database driver
so open mvnrepo -> postgres 
always pick the stable version. how to identify? 

CHOOSING OPTIMAL VERSION OF DEPENDENCY:

chatgpt:
How To Know If A Version Is Stable
When you look at versions (like on Maven), watch the suffix.
1. If it says:
Alpha → not optimal -> very early testing
Beta →  not optimal -> still testing
CR (Candidate Release) → ⚠ almost ready, but not final
RC (Release Candidate) → ⚠ very close to release
M1 / M2 (Milestone) → not optimal -> experimental milestone builds
These are not fully stable.

2. If it says:
Final -> most optimal */


//with hibernate and postgres, jakarta.persistence also downloaded, hint: its something to do with JPA
/*so we get our deps in the maven project, reload, setup done */
//pojo means plain old java object



/*
STORING DATA IN DB USING HIBERNATE:
Session is an interface, we cannot directly instantiate so we find a way around to create its object
to access the session we need SessionFactory which is again an interface, 
for any unit of work i'll be needing a session
Configuration is a class so we directly instantiate, 
object of Configuration uses a method (cfg.buildSessionFactory), which gives the object of SessionFactory
using which we can create multiple sessions. 

we complete the configuration part by creating a file called hibernate.cfg.xml in resources folder
we add the hibernate configuration tag, something like this,

<hibernate-configuration xmlns="http://www.hibernate.org/xsd/orm/cfg">
    <session-factory>

    </session-factory>
</hibernate-configuration>

inside the factory we mention:
1. driver class -> the driver im working with which is org.postgresql.Driver here (drivername keeps changing depending upon the database)
2. db url mentioning ip and port number, and db name
3. db username
4. db password
now cfg It holds all your Hibernate setup — database URL, username, password, properties, etc.

in Main.java we add
cfg.addAnnotatedClass(com.kenny.Student.class); 
This method tells Hibernate to Scan this class for annotations like @Entity, @Table, @Id, etc.

@Entity
@Table(name="student")
public class Student {
    @Id
    private int id;
}

Hibernate now understands:
Which table to map
Which column is primary key
How to create SQL queries for it

com.kenny.Student.class
This is: The fully qualified class name
com.kenny → package
Student → class
.class → Java's way of passing the Class object (metadata)

It’s not creating an object.
It’s passing the blueprint of the class.


so if we want the class to be managed by hibernate, we have to use annotations
so we add @Entity, its import includes jakarta.persistence (import jakarta.persistence.Entity)




if you go back to database principles, we got this ACID property.
So every time you save data it's a transaction.
saving data = doing a transaction
And after transaction you have to commit the transaction.
Otherwise this will not save.
so we commit, now commit belongs to the transaction.
So before you save it you create the object of transaction from hibernate package.
transaction itself is a interface.
So if you go to session.beginTransaction.
It will return the object of transaction.

we still dont have a table, so we ask hibernate to create a table
so in hibernate.cfg.xml in session factory we add
// hbm2ddl.auto -> hibernate mapping to data definition language by default auto
<property name="hibernate.hbm2ddl.auto">create</property> but this attempts to create a table everytime-> firstly it creates table, if the table with same name exists, it drops (deletes) the previous table and creates a new one.

<property name="hibernate.hbm2ddl.auto">createDrop</property> this creates a table and once its done it drops the table within the same session
OR 
<property name="hibernate.hbm2ddl.auto">update</property> 
this uses a table if the table exists.
if there's a change in schema, update will do that.
It can also add a new column, but it wont remove the old columns
but only use this in development, never in production  */



/*
hibernate uses jdbc behind the scenes, so indirectly it uses the queries to perform operations
to see those queries we add 
<property name="hibernate.show_sql">true</property> in the session factory (hibernate.cfg.xml)
//this goes in the ascending order of characters, with primary key always at the end -> default format
to change the format we use:
<property name="hibernate.format_sql">true</property> which is by default set false

In database world, dialect = version of SQL for a specific database.
Because plot twist:
SQL is not exactly the same everywhere.
Hibernate needs to know which database are we talking to. so we add:
<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
adding properties always help  */


/* optimising the code further #refactoring

1. since SessionFcatory is a heavy weight object it consumes a lot of resources so we should either use try with resources or
 simply close the session and session factory manually ->  session.close(); sf.close();

2. Configuration cfg = new Configuration();
   cfg.addAnnotatedClass(com.kenny.Student.class);
   cfg.configure();

   instead of 3 lines we compose all in 1 :

    SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.kenny.Student.class)
                .configure()
                .buildSessionFactory();  //cfg.buildSessionFactory();  */



/* HOW DO WE FETCH DATA USING HIBERNATE?

do we need transaction here?
In this scenario, since there is no other dependency, we can remove the transaction because when you
are fetching data, you don't need transaction object or you don't have to begin the transaction.
It's only needed when you are doing some manipulation in the database.

we create a new object, make it null. we do
s2 = session.find(Student.class, 18);
this fetches the values of the object whose primary key is 18. stores it in s2 object.
we don't have to convert the value given by the SQL query into the object format.
hibernate/orm does that automatically behind the scene.  */



/* HOW DO WE UPDATE AND DELETE DATA USING HIBERNATE?

both update and delete requires transaction

to update: 
session.merge(s1); -> it first fires the select query if the data is there , it updates, otherwise fire insert query new data

to delete:
we first fetch the object by searching for its primary key then pass the object
session.remove();  */


/* revision:

Hibernate works like this:
While the Session is open → it tracks objects (managed state).
When the Session closes → Hibernate stops tracking them.
So when session closes:
Object still exists in memory.
But Hibernate is no longer watching it.
So changes won’t auto-update the database.
That’s why we need merge() later —
to reattach the object and sync changes

Hibernate/JPA Session methods:

1. persist() → Saves a new object to the database (makes it managed).
2. find() → Fetches an object from the database using its primary key.
3. merge() → Updates a detached object by copying its state into a managed entity.

You had an object.
Session closed → it became detached (not tracked).
You modified it.
You opened a new session.
Hibernate isn’t tracking that old object anymore.
So you use merge() to copy its updated data into a new managed object and update the database.

4. remove() → Deletes an object from the database.  */



/* CHANGING TABLE AND COLUMN NAMES:
we do it by using annotations. annotations are always written above the target line

changing table name:

by default, class name = entity name = table name 
if i want a different table name from the class name, we can change entity name and use @Entity(name="name2") so classname != entityName = tableName
if i dont want to change my entity name, we change the table name and use @Entity @Table(name="name2") -> this changes the table name, classname = entityName != tableName   

changing column name: add annotation @Column(name="name2") above the target variable
if i dont want to add something into the database: add annotation @Transient above the the target.   */




/*EMBEDDABLES:

complex types-> using class type variables in database
in order to make complex type variables embeddable (to insert class type variable into table which contains multiple instance variables)
and i want to add those variables into table such that the table expands into total number of variables count 
both complex type variables and normal int, string type)
so we make it jdbc type by adding @Embeddable above the target complex type (class of that variable)  


this does not fire select query tho?
Because laptop is an object,
it should be having its own identity,
so, it should have a separate table as an entity.

what if one person has multiple laptops,
or one alien has multiple laptops?
You can't simply put adding the columns, right?
And this will create inconsistency,
so we create a separate entity table  */




/* MAPPING RELATIONSHIP THEORY

we either connect two tables by adding the primary key column of table1 
as the foreign key column of table2
1. one to one -> if 1 alien has 1 laptop
2. one to many (from aliens perspective) -> if 1 alien has multiple laptops
3. many to one (from laptops perspective) -> if multiple laptops are assigned to 1 alien
                                           OR
create a third table alien_laptop showcasing this alien has this this laptop using primary keys
from both the tables.

in case of one to many or many to one we can either create third table or connect 2 tables 
but in case of many to many, its a necessity to create a third table.



IMPLEMENTING ONE TO ONE -> 

in laptop class we specify the entity as laptop class and lid as primary key ()
in alien class we mention the annotation @OneToOne above the target entity (embedded complex variable before)
we save both the tables.



IMPLEMENTING ONE TO MANY ->

in alien class we provide a list of laptops, get getter and setter for list, edit toString. change the annotation to @OneToMany
in main.java we create 2 laptop objects, store both the objects in array format
session persists/stores all the objects 1 alien, 2 laptops.
this creates a third table in the database: alien_laptop using lid and aid for this table, none of them is primary key.
both the columns of aliens pk and laptops pk combine together to form a composite key.
that composite key is unique.

what if we dont want to create an extra table in the scenario?

mappedBy = "who is mapping it"


IMPLEMENTING MANY TO MANY ->

both creates a mapping table. i want only alien to map it so i need to stop laptop from mapping, so in Laptop class
i add annotation mappedBy = " " here we need to go to the other class and see who is doing the mapping, (done by laptops here)  */




/*HIBERNATE EAGER AND LAZY FETCH 

make sure hb2ddl property in cfg.xml is create.
Eager and lazy fetching are strategies in Hibernate that decide **when related data should be loaded from the database**.
In lazy fetching, the main entity is loaded first, and its related data (like a collection in a `@OneToMany` relationship) is not fetched immediately.
Hibernate waits until you actually access that related data, and only then does it fire an additional query.
This improves performance because unnecessary data is not loaded into memory.
Lazy fetching is the default for collections like `@OneToMany` and `@ManyToMany`, and it is generally recommended in production when dealing with large datasets. 
However, if you try to access lazily loaded data after the session is closed, it can throw a `LazyInitializationException`.

In contrast, **eager fetching** loads the main entity and its related data at the same time. 
As soon as you fetch the entity, Hibernate immediately retrieves the associated objects as well, usually using a JOIN query. 
This ensures that all required data is available instantly, but it can negatively impact performance if the related data is large or not always needed. 
Eager fetching is the default for single-valued relationships like `@ManyToOne` and `@OneToOne`. 
In practice, lazy fetching is preferred unless you are certain that the related data will always be required.

specify @OneToMany (fetch = FetchType.EAGER)  this for eager fetching  */



/* Hibernate caching:

Application Flow-
Client (like React) sends request → Server → Database.
Server opens a Hibernate Session to interact with DB.
What Happens When Fetching Data?
If Alien 101 data is requested in Session S1 →
Hibernate fires a query → gets data → stores it in session cache.
If 101 is requested again in the same session. No new query is fired. Data is returned from session cache.
This is Level 1 Cache (L1 Cache).

When Multiple Different IDs Are Requested
Fetch 101 → query fired.
Fetch 102 → query fired.
Because they are different records.

Why L1 Cache Is Good?
Reduces database hits.
Improves performance.
Works automatically (enabled by default).

Potential Problem?
If data changes in DB while session is still active,
Hibernate may return stale data from cache.
So caching must be used carefully.

Scope of Level 1 Cache
Works only inside the same session.
Session S1 and Session S2 do NOT share cache.
So:
S1 has Alien 101 cached.
S2 asks for Alien 101. It will fire a new query.

Level 2 Cache (L2 Cache)
Used when you want cache sharing across sessions.
Requires external libraries.
Uses JCache standard.
Common implementations:
Ehcache
Caffeine

Final Takeaway
L1 Cache = Default, session-scoped, automatic.
L2 Cache = Shared across sessions, requires configuration.
Caching improves performance but can return outdated data if not handled properly.  */



/* Hibernate schema generation strategy or Hibernate DDL auto configuration property
Basically, hibernate.hbm2ddl.auto defines the schema management strategy — how Hibernate should handle database tables at startup.

e.g: <property name="hibernate.hbm2ddl.auto">update</property>

none → Hibernate does absolutely nothing to the database.
validate → Checks if DB matches entities, throws error if not.
update → Updates schema without deleting existing data.
create → Drops old tables and creates new ones every startup.
create-drop → Creates tables on start, drops them when app stops.  */




/* HQL - hibernate query language

SQL (Structured Query Language) is used to interact directly with relational databases like Oracle Corporation databases, MySQL, or PostgreSQL, 
and it allows developers to perform CRUD operations—create, read, update, and delete—using queries like `SELECT`, `INSERT`, `UPDATE`, and `DELETE`.
With SQL, you work directly with tables and columns, and you can use clauses like `WHERE`, `JOIN`, and `GROUP BY` to perform complex filtering and 
data manipulation. However, when working with Hibernate in Java, developers typically interact with objects rather than writing SQL manually. 
Hibernate provides simple methods like `get()`, `save()`, `update()`, and `delete()` to handle common database operations using entities and 
primary keys. But when more complex queries are needed—such as searching by name or filtering by a specific field instead of the primary 
key—Hibernate offers HQL (Hibernate Query Language). HQL is similar to SQL in syntax, but instead of referring to table names and column names, 
it uses entity names and their property names. For example, instead of writing `SELECT * FROM student`, in HQL you can simply write `FROM Student`, 
where `Student` is an entity class. Internally, Hibernate converts HQL into SQL before sending it to the database, allowing developers to stay within 
the object-oriented programming model while still leveraging powerful querying capabilities.  

FETCHING DATA USING HQL:
(we dont need transaction for fetching data)
using find method can fetch data on the basis of primary key only
if we want to fetch on basis of some other info which is NOT a pk then we use hql,
suppose we wanna fetch all the data of object whose ram is 32 (ram is not pk here),

if we used sql the query would be ->
select * from Laptop where ram=32

if we used hql the query would be ->
from Laptop where ram=32

Query is an interface; query.getResultList() ggives a list of values
from Laptop where ram=32
we did this because we knew theres atleast an obj whose ram is 32 but 
what if this value is coming from a database or its unknown
see code
*/



/* get() vs load()
       or
eagerFetching vs lazyFetching

difference : 
firing select query in get() even when not accessed
doesnt fire query in load() unless data is accessed  */



/* Level2 cache using Ehcache

level1 cache: 
When you call session.get(Student.class, 1) in Hibernate, Hibernate first checks the Level 1 cache inside that session. 
If the object with primary key 1 is not already there, Hibernate fires a SELECT query to the database, fetches the row, converts it into a Java object, 
and then stores that object inside the session’s Level 1 cache. Now the session remembers it. If you call get() again for the same ID within the same session, 
Hibernate will not hit the database again — it simply returns the cached object. This improves performance because repeated database calls are avoided.

The Level 1 cache exists only for the lifetime of that session. 
Once the session is closed, everything stored in that cache disappears. If you call session.clear(), 
the entire cache is emptied immediately. If you call session.evict(entity), only that specific object is removed from the cache. 
Also, Hibernate tracks changes to cached objects (this is called dirty checking). So if you modify a property of a fetched entity inside a transaction and commit, 
Hibernate automatically detects the change and fires an UPDATE query — even if you never explicitly called update.

Level2 cache:
-> can be implemented using external libs like caffeine, Ehcache
add deps in pom.xml -> ehcache, jcache, hibernate-core, jaxb-runtime reload maven

to specify we want to use l2 cache we add annotation @Cacheable above Laptop class
then even if we are accessing same id in different sessions, hibernatev fires query only once
we can also specify more properties in cfg.xml to avoid errors:


<!--        <property name="hibernate.cache.use_second_level_cache">true</property>-->
<!--        <property name="hibernate.cache.region.factory_class">org.hibernate.cache.jcache.JCacheRegionFactory</property>-->
<!--        <property name="hibernate.jakarta.cache.provider">org.ehcache.jsr107.EhcacheCachingProvider</property>-->   */
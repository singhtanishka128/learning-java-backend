/* download. 

servers → postgreSQL version → databases appear

to create a database, right click on databases → create database. enter db name → save.

to create a table → schemas → tables → create table. enter table name → enter col name, type, primary key is a must 
if further some other table wants to fetch data from this table so we refer this primary key to connect ;  
also to make sure we only enter unique data, no duplicacy / ”redundancy”...not null → true/on → to make sure no student id 
/s.id cell is empty. 

table right click → view/edit data → all rows → we can either enter data from the table format manually or 
we can do from the query tool, write sql / queries there. (go learn sql language) 
after writing the query, execute otherwise the effect wont run.

thats how we do things in postgres */






/* sql queries/operations:

1. to get all the data :  select * from tablename ;

2. to get specific data from specific row : select columnName from tableName where primarykey/columnNme = xyzVlue
eg. select sname from student where sid = 1

3. to insert data into row : insert into tableName values ( 1', ‘Tanishka’, 100);  
//if table has 3 columns -> column 1 & 3 are of type integer. col 2 of type String
eg. insert into student values ( 1, ‘Tanishka’, 100);  */






/* ResultSet interface, rs is ResultSet object used to get the response

rs.next() -> checks if theres a next row and also puts a pointer to the next row
rs.getString("colName"); to get data by mentioning column name
rs.getInt(1); to get data by mentioning column index number (indexing starts from 1)  */


/* CRUD operations ->
create = insert
read   = fetch
update = update 
delete = delete

st.executeQuery(sql) returns resultSet

st.execute(sql) can return different types of data, it returns resultSet if its an sql query,
returns count if its is insert or update query so if it returns false that indicates an insert query  */




/* why do we need prepared statements?

how do we insert data? "insert into student values(101, 'Latika', 89)"
now here the values were hard coded what if i need to pass them in the form of their variable name? 
int sid = 101, String sname = "Latika" , int smarks = 89;
"insert into student values (" + sid + ", '" + sname + "'," + smarks + ")" ;
here the concatenation becomes so tedious */



/* //Class.forName("org.postgresql.Driver");
-> Loads and registers PostgreSQL driver.
   (Commented because modern JDBC auto-loads driver.)


Connection con = DriverManager.getConnection(url, uname, pass);
-> Creates a connection between Java application and database.
   Returns a Connection object.


Statement st = con.createStatement();
-> Creates a Statement object using the connection.
   Used to send SQL queries.



ResultSet rs = st.executeQuery(sql);
-> Executes SELECT query.
   Returns ResultSet containing fetched data.


String name = rs.getString("sname");
-> Fetches value of column sname from current row.
   Stores it in variable name


con.close();
-> Closes database connection.
   Releases database resources.


*/
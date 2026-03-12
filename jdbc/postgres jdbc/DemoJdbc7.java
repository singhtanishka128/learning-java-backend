/* PREPARED STATEMENTS -> inserting / Creating -> C-r-u-d

//inserting a row
in java, we have Statement, PreparedStatement, CallableStatement
whenever you want to execute a stored procedure, we use callable statement.

if you want to do anything which deals with 
updating the table itself,
the structure dropping table,
or altering the table,
for select query,
then the statement makes sense.

But for others, it's better
to go for prepared statement.
In fact, for select, when you have a word clause,
always use a prepare statement.

PreparedStatement is an interface which extends Statement -> type of a statement with more features
we pass the sql query, this gives us a pre-compiled query,
which you can use it for the caching purpose.
*/


/*whatever data is dynamic we just replace it with the question mark and 
define/set the question mark respectively later */

import java.sql.*;      //step1 import package

public class DemoJdbc7 {
    public static void main(String[] args) throws Exception {

        /*
        steps:
        import package
        load and register
        create connection
        create statement
        execute statement
        process the results
        close
         */

        int sid = 103; String sname= "paris"; int smarks = 96;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Tanishka$28";
        String sql = "insert into student values (?,?,?)" ;

        Connection con = DriverManager.getConnection(url, uname, pass);  //step3 create connection

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, sid); //takes 2 parameters -> column number, data
        st.setString(2, sname);
        st.setInt(3, smarks);

        st.execute();

        con.close();
    }
}

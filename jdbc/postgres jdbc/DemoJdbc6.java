//why do we need prepared statements?
//tedious way of concatenating variables when passing into sql query -> ew 

import java.sql.*;      //step1 import package

public class DemoJdbc6 {
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

        
        int sid = 101; String sname= "Latika"; int smarks = 94;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Tanishka$28";
        String sql = "insert into student values (" + sid + ", '" + sname + "'," + smarks + ")" ;

        //Class.forName("org.postgresql.Driver"); //step2 load and register
        Connection con = DriverManager.getConnection(url, uname, pass);  //step3 create connection
        System.out.println("Connection Established");
        Statement st = con.createStatement();  // step4 create statement
        st.execute(sql);

        con.close();
        System.out.println("Connection closed");
    }
}

// output:
// Connection Established
// Connection closed


/* why using the old Statement way is bad idea/ why do we need prepared statement?

1.we shouldnt use this tedioous way of inserting data into db, v confusing
2.we need to stop sql injections
3.we want to improve performance by caching the queries

caching the queries? 
If you run the same SQL query multiple times, sending it again and again through JDBC is inefficient.
A PreparedStatement solves this.
It sends the query to the database once, the database pre-compiles and caches it, and after that you just pass different values (parameters) 
to execute it again.
So instead of re-sending the whole query every time, you reuse the prepared one — faster, cleaner, smarter.  */ 
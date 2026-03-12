// c-r-U-d --> Update

//to update data 
//sql query = "update student set sname = 'Max' where sid=5"

import java.sql.*;      //step1 import package

public class DemoJdbc4 {
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

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Tanishka$28";
        String sql = "update student set sname = 'Max' where sid=5" ;

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
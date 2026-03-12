// C-r-u-d --> Create / insert

//inserting new row
//sql query = "insert into student values(7, 'Dan', 86)"

import java.sql.*;      //step1 import package

public class DemoJdbc3 {
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
        String sql = "insert into student values(7, 'Dan', 86)" ;

        //Class.forName("org.postgresql.Driver"); //step2 load and register
        Connection con = DriverManager.getConnection(url, uname, pass);  //step3 create connection
        System.out.println("Connection Established");
        Statement st = con.createStatement();  // step4 create statement
        boolean status = st.execute(sql);
        System.out.println(status);

        con.close();
        System.out.println("Connection closed");
    }
}

// output:
// Connection Established
// false
// Connection closed

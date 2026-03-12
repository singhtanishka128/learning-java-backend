// c-R-u-d --> Read

//fetching all data
//sqlquery = " select * from student; "

import java.sql.*;      //step1 import package

public class DemoJdbc2 {
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
        String sql = "select * from student" ;

        //Class.forName("org.postgresql.Driver"); //step2 load and register
        Connection con = DriverManager.getConnection(url, uname, pass);  //step3 create connection
        System.out.println("Connection Established");
        Statement st = con.createStatement();  // step4 create statement
        ResultSet rs = st.executeQuery(sql); //step5 execute statement

        while(rs.next()){
            System.out.print(rs.getInt(1)+" - ");
            System.out.print(rs.getString(2)+" - ");
            System.out.println(rs.getInt(3));
        }

        con.close();
        System.out.println("Connection closed");
    }
}

// output:
// Connection Established
// 1 - Tanishka - 91
// 2 - Shakira - 91
// 3 - Veera - 99
// 4 - Meera - 98
// Connection closed
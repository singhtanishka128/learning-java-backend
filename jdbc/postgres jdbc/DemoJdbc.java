// c-R-u-d --> Read

//to get the specific data from specific row ->  rs.getString("colname")
//to check whether the next row exists or not, if yes-> moves the pointer to next     rs.next()
//query = select sname from student where sid = 1

import java.sql.*;      //step1 import package

public class DemoJdbc {
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
        String sql = "select sname from student where sid = 1" ;

        //Class.forName("org.postgresql.Driver"); //step2 load and register
        Connection con = DriverManager.getConnection(url, uname, pass);  //step3 create connection
        System.out.println("Connection Established");
        Statement st = con.createStatement();  // step4 create statement
        ResultSet rs = st.executeQuery(sql); //step5 execute statement
        System.out.println(rs.next()); //step6 response processing
        String name = rs.getString("sname");
        System.out.println("name of the student is : " + name);
        con.close(); //step7 close
        System.out.println("Connection closed");
    }
}

// output:
// Connection Established
// true
// name of the student is : Tanishka
// Connection closed






 







//fetching data from database 


package com.kenny;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setsAge(24);
        s1.setsName("Avni");
        s1.setRollNo(19);

        Student s2 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.kenny.Student.class)
                .configure()
                .buildSessionFactory();  //cfg.buildSessionFactory();

        Session session = sf.openSession();

        //fetching data on basis of primary key
        s2 = session.find(Student.class, 12);

        session.close();
        sf.close();

        //always check, we cannot gurantee if the object with such primary key exists or not so
        // if the object is null throws exception therefore use try catch
        System.out.println(s2.getsName());
    }
}


// output:
// Hibernate: 
//     select
//         s1_0.rollNo,
//         s1_0.sAge,
//         s1_0.sName 
//     from
//         Student s1_0 
//     where
//         s1_0.rollNo=?
// Harsh
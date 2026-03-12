//Storing data using more optimised format


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
        
//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(com.kenny.Student.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.kenny.Student.class)
                .configure()
                .buildSessionFactory();  //cfg.buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();
        session.close();
        sf.close();

        System.out.println(s1);
    }
}

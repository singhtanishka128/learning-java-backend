//updating data using hibernate


package com.kenny;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setsName("Diya");
        s1.setRollNo(28);
        s1.setsAge(21);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.kenny.Student.class)
                .configure()
                .buildSessionFactory();  //cfg.buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.merge(s1); //find and update else insert

        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);
    }
}

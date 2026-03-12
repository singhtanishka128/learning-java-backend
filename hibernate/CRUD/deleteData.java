//deleting data using hibernate


package com.kenny;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.kenny.Student.class)
                .configure()
                .buildSessionFactory();  //cfg.buildSessionFactory();

        Session session = sf.openSession();

        s1 = session.find(Student.class, 1); //finding object

        Transaction transaction = session.beginTransaction();

        session.remove(s1); //passing the object to delete from db

        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);
    }
}

//one to one mapping

package com.kenny;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Asus");
        l2.setModel("Vivobook");
        l2.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Tanishka");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l1,l2));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.kenny.Alien.class)
                .addAnnotatedClass(com.kenny.Laptop.class)
                .configure()
                .buildSessionFactory();  //cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(a1);

        transaction.commit();

        Alien a2 = session.find(Alien.class, 101);
        System.out.println(a2);

        session.close();
        sf.close();
    }
}

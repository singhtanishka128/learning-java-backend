//fetching the entire data of object whose value matches

package com.kenny;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.kenny.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

       // Query query = session.createQuery("from Laptop where ram=32 "); //when an int attribute is known
       // Query query = session.createQuery("from Laptop where brand like 'Asus' "); //when a string attribute is known
       
       String brand = "Apple";
       Query query = session.createQuery("from Laptop where brand like ?1 ");
       query.setParameter(1, brand);
       List<Laptop> laptops = query.getResultList();

        System.out.println(laptops);

        session.close();
        sf.close();
    }
}
//in console we get all the data of object whose brand is Apple

//fetching only 1 data field (model) whose brand matches
//one data so list type is -> List<String> laptops

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

        String brand = "Asus";
        Query query = session.createQuery("select model from Laptop where brand like ?1 ");
        query.setParameter(1,brand);
        List<String> laptops = query.getResultList();

        System.out.println(laptops);

        session.close();
        sf.close();
    }
}


//[Rog, Vivobook, Strix]


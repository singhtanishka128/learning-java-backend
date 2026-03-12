//fetching 2 data fields
//list because we are fetching multiple rows
//object because we are specifying multiple cols/properties
//for fetching data we running enhanced for loop
//at a time we getting 1 particular row, 
//since they are by default objects we have to typecast into string



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
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1 ");
        query.setParameter(1,brand);
        List<Object[]> laptops = query.getResultList();

        for(Object[] data : laptops){
            System.out.println((String)data[0] + " " + (String)data[1]);
        } // enhanced for loop

        System.out.println(laptops);

        session.close();
        sf.close();
    }
}



// Asus Rog
// Asus Vivobook
// Asus Strix

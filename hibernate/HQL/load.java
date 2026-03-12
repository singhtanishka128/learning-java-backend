//load 

//we use load, we print -> fires query
//we dont print -> DOESNT fire select query


package com.kenny;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.kenny.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        //Laptop laptop = session.load(Laptop.class, 2); //load
        Laptop laptop = session.getReference(Laptop.class, 2); //alternative of load since load is depricated


        session.close();
        sf.close();
    }
}

//get

//we use get, we print -> fires query
//we dont print -> still fires query
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

        Laptop laptop = session.get(Laptop.class, 2); //get

        session.close();
        sf.close();
    }
}
//fires the select query even when not accessing data
package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Student student = new Student();
        student.setId(103);
        student.setName("Krushn");
        student.setCity("Mathura");
        System.out.println(student.toString());

        // Creating object of Address
        Address address = new Address();
        address.setStreet("Street2");
        address.setCity("Mathura");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(123.12);
        FileInputStream fis = new FileInputStream("src/main/ExtraResources/image.jpg");
        byte[] data = new byte[fis.available()];
        fis.read();
        address.setImage(data);


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        session.persist(address);
        transaction.commit();
        session.close();

        System.out.println("Done..");
    }
}

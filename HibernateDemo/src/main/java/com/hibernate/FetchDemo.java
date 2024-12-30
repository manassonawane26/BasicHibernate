package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        // get or load
        Configuration cfg = new Configuration();
        cfg.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        // get - student 104
        Student student = session.get(Student.class, 104);
        System.out.println(student);

        // load - address 2
        Address address= session.load(Address.class, 2);
        System.out.println(address.getCity());
        sessionFactory.close();
    }
}

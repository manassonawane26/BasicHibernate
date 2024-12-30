package com.caching;

import com.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstCacheDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Student st = session.get(Student.class, 5);
        System.out.println(st);
        System.out.println("Performed some work");
        Student st1 = session.get(Student.class, 5);
        System.out.println(st1);

        System.out.println(session.contains(st));
        System.out.println(session.contains(st1));
        session.close();
        sessionFactory.close();
    }
}

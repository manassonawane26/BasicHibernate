package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Student student1 = new Student();
        student1.setId(105);
        student1.setName("Vithhal");
        student1.setCity("Pandharpur");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Management");
        certificate1.setDuration("28 Yug");
        student1.setCert(certificate1);


        Student student2 = new Student();
        student2.setId(106);
        student2.setName("Swami Samarth");
        student2.setCity("Akkalkot");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Mass Media");
        certificate2.setDuration("200 years");
        student2.setCert(certificate2);


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student1);
        session.persist(student2);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

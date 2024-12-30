package com.states;

import com.hibernate.Certificate;
import com.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StatesDemo {
    public static void main(String[] args) {
        // Transient
        // Persistent
        // Detached
        // Removed
        Configuration cfg = new Configuration().configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Student student = new Student();
        student.setId(21113);
        student.setName("States Ex");
        student.setCity("Pune");
        student.setCert(new Certificate("Java HiberNate Course", "2 Months"));
        // now in transient State


        Session session = sessionFactory.openSession();
        Transaction transaction  = session.beginTransaction();
//        session.save(student);
//        // Persistent State
//        student.setName("Java HiberNate Course changed after s.save");
//        transaction.commit();
//
//        session.close();
//        //Detached State
//        student.setName("Java HiberNate Course changed after s.save 2"); // this will not be done


//        transaction  = session.beginTransaction();
        student = session.get(Student.class, 21112);
        session.delete(student); 
        transaction.commit();
        // Removed State
        sessionFactory.close();
    }
}

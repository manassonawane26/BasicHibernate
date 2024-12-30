package com.sqlquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import java.util.List;

public class SQLExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        NativeQuery query = session.createNativeQuery("select * from Student");

        // The Query is run on the table and not the class so if we execute below code it will give cast exception as: Exception in thread "main" java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast to class com.hibernate.Student ([Ljava.lang.Object; is in module java.base of loader 'bootstrap'; com.hibernate.Student is in unnamed module of loader 'app')
        //	at com.sqlquery.SQLExample.main(SQLExample.java:20)
//        List<Student> list = query.list();
//
//        for (Student st : list) {
//            System.out.println(st.getName());
//        }

        // storing quer.list() into an object array
        List<Object[]> list = query.list();
//        for (Object[] st : list) {
//            System.out.println(Arrays.toString(st));
//        }
        //printing name ans city
        for (Object[] st : list) {
            System.out.println(st[4] + " : " + st[1]);
        }


        session.close();
        sessionFactory.close();
    }
}

package com.hql;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Select Query Example 
//        String query = "from Student";
//        String query = "from Student where city = 'pune'";
//        String query = "from Student where city = :x";
//        String query = "from Student as s where city = :x and s.name = :y";
//        Query q = session.createQuery(query);
//        q.setParameter("x", "nagar");
//        q.setParameter("y", "chintu");
//        //if we expect single unique result
//        // q.uniqueResult();
//        // for multiple results
//        List<Student> list = q.list();
//        for(Student s: list){
////            System.out.println(s.getName());
//            System.out.println(s.getName() + " : " + s.getCert().getCourse());
//        }

        System.out.println(" ________********________");

//        Transaction tx = session.getTransaction();
//        tx.begin();
        Transaction tx = session.beginTransaction();

        // Delete Query Example
//        Query q2 = session.createQuery("Delete from Student s where s.city= :c and name= :n");
//        q2.setParameter("c", "Pune");
//        q2.setParameter("n", "kushal");
//        int row = q2.executeUpdate();
//        System.out.println("Rows Deleted: " + row);

        System.out.println(" ________********________");

//        // Update Query Example
//        Query q3 = session.createQuery("update Student s set s.city =:c where s.name =:n");
//        q3.setParameter("c", "Nashik");
//        q3.setParameter("n", "chintu");
//        int row = q3.executeUpdate();
//        System.out.println("Rows Updated : " + row);

        // Join Example
        Query q4 = session.createQuery("select q.questionId, q.question, a.answer from Question as q INNER JOIN q.answers as a");
        List<Object[]> list2 = q4.getResultList();
        for(Object[] obj: list2){
            System.out.println(Arrays.toString(obj));
        }

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}

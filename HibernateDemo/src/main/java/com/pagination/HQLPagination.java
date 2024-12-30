package com.pagination;

import java.util.List;
import com.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        query.setFirstResult(3);
        query.setMaxResults(7);
        List<Student> list = query.list();
        for(Student st : list){
            System.out.println(st.getId() + " : " + st.getName() + " : " + st.getCity());
        }


        session.close();
        sessionFactory.close();
    }
}

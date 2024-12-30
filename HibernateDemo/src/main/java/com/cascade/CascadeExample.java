package com.cascade;


import com.mappingDemo.Answer;
import com.mappingDemo.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.ArrayList;

public class CascadeExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        Question q1 = new Question();
        q1.setQuestionId(1021);
        q1.setQuestion("what is cascading");

        Answer a1 = new Answer(10121, "Answer1");
        Answer a2 = new Answer(10122, "Answer2");
        Answer a3 = new Answer(10123, "Answer3");

        // Because question Id was null without setting question to answer
        a1.setQuestion(q1);
        a2.setQuestion(q1);
        a3.setQuestion(q1);

        List<Answer> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q1.setAnswers(list);

        Transaction tx = session.beginTransaction();

        session.save(q1);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}

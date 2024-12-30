package com.mappingDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemoClass {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Creating Question
//        Question question1 =  new Question();
//        question1.setQuestionId(1);
//        question1.setQuestion("What is Java?");
//
//        // Creating Answer
//        Answer answer1 = new Answer();
//        answer1.setAnswerId(101);
//        answer1.setAnswer("Java is a Programming Language");
//        answer1.setQuestion(question1);
//
//        Answer answer2 = new Answer();
//        answer2.setAnswerId(102);
//        answer2.setAnswer("Java is very secure");
//        answer2.setQuestion(question1);
//
//        Answer answer3 = new Answer();
//        answer3.setAnswerId(103);
//        answer3.setAnswer("Java is a used to create large scale applications");
//        answer3.setQuestion(question1);
//
//        List<Answer> answerList = Arrays.asList(answer1,answer2, answer3);
//        question1.setAnswers(answerList);


        // Creating Question
//        Question question2 =  new Question();
//        question2.setQuestionId(2);
//        question2.setQuestion("What is Collection Framework?");

        // Creating Answer
//        Answer answer2 = new Answer();
//        answer2.setAnswerId(102);
//        answer2.setAnswer("Set of APIs to to work with objects in Java");
//        answer2.setQuestion(question2);
//        question2.setAnswer(answer2);

        // Session
        Session session = sessionFactory.openSession();
        Transaction transaction  = session.beginTransaction();

//        // save
//        session.persist(answer1);
//        session.persist(answer2);
//        session.persist(answer3);
//        session.persist(question1);


        // Fetch Many to one mapping data
        Question q = session.get(Question.class, 1);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());

//        for(Answer answer: q.getAnswers()){
//            System.out.println(answer.getAnswerId() +": "+ answer.getAnswer());
//        }
        transaction.commit();

        // Fetching
//        Question question = session.get(Question.class, 1);
//        System.out.println(question.getQuestion());
//        System.out.println(question.getAnswer().getAnswer());
//
//        Answer answer = session.get(Answer.class, 102);
//        System.out.println(answer.getQuestion().getQuestion());
//        System.out.println(answer.getAnswer());

        session.close();
        sessionFactory.close();
    }
}

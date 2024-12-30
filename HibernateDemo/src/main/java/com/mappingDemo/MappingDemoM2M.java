package com.mappingDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemoM2M {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Employee emp1= new Employee();
        Employee emp2= new Employee();
        emp1.setEid(1);
        emp1.setName("Employee1");
        emp2.setEid(2);
        emp2.setName("Employee2");

        Project p1 = new Project();
        Project p2 = new Project();
        p1.setPid(105);
        p1.setpName("Library mgmt system");
        p2.setPid(106);
        p2.setpName("ChatBot");
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(emp1);
        employees.add(emp2);
        List<Project> projects = new ArrayList<Project>();
        projects.add(p1);
        projects.add(p1);

        emp1.setProjects(projects);
        p2.setEmployees(employees);


        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(emp1);
        session.save(emp2);
        session.save(p1);
        session.save(p2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}

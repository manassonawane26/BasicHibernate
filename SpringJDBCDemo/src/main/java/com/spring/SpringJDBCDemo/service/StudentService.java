package com.spring.SpringJDBCDemo.service;

import com.spring.SpringJDBCDemo.model.Student;
import com.spring.SpringJDBCDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student student) {
        repo.save(student);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}

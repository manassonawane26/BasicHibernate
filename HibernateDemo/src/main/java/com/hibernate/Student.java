package com.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String city;
    private Certificate cert;
    public Student(int id, String city, String name) {
        this.id = id;
        this.city = city;
        this.name = name;
    }
    public Student(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Certificate getCert() {
        return cert;
    }

    public void setCert(Certificate cert) {
        this.cert = cert;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

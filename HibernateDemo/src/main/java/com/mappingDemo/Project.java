package com.mappingDemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    @Column(name="project_name")
    private String pName;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    public Project() {
    }

    public Project(int pid, String pName, List<Employee> employees) {
        this.pid = pid;
        this.pName = pName;
        this.employees = employees;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

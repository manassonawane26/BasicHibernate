package com.mapping.xml;

public class Person {
    private int it;
    private String name;
    private String address;

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(int it, String name, String address) {
        this.it = it;
        this.name = name;
        this.address = address;
    }

    public Person() {
        super();
    }
}

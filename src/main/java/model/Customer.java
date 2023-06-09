package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    // This field serves as a db id.
    private static final AtomicInteger i = new AtomicInteger(0);
    private final int id;
    // companyId is a foreign key
    private Company company;
    private String name;
    private String surname;
    private int age;
    private Month monthOfRegister;

    public Customer( String name, String surname, int age, Month monthOfRegister,Company company) {
        this.id = i.incrementAndGet();
        this.company = company;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.monthOfRegister = monthOfRegister;
    }


// Getter and Setters
    //********************************************************************************************************************

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Month getMonthOfRegister() {
        return monthOfRegister;
    }

    public void setMonthOfRegister(Month monthOfRegister) {
        this.monthOfRegister = monthOfRegister;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "name: "+name+"\n"+
                "surname: "+surname+"\n"+
                "age: "+age+"\n"+
                "Month of register: "+monthOfRegister+"\n"+
                "Company name: "+company.getName()+"\n";
    }
}

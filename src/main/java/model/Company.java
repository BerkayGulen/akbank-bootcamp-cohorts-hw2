package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Company {
    private static final AtomicInteger i = new AtomicInteger(0);
    private final int id;

    private String name;
    private String sector;

    public Company(String name, String sector) {
        this.id = i.incrementAndGet();
        this.name = name;
        this.sector = sector;
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Company {
    private static final AtomicInteger i = new AtomicInteger(0);
    private final int id;

    private String name;
    private String sector;
    private List<Order> orders;

    public Company(String name, String sector) {
        this.id = i.incrementAndGet();
        this.name = name;
        this.sector = sector;
        this.orders = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name+"\n"+sector+"\n";
    }

    // Getter and Setters
    //********************************************************************************************************************
    public void addOrder(Order order){
        orders.add(order);
    }
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

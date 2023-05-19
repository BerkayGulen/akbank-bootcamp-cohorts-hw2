package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger i = new AtomicInteger(0);
    // This field serves as a db id.
    private final int id;
    /* customerId is a foreign key. I wanted to make my classes as close as possible to the db tables.
    I did not want to store entity inside entity or list inside my classes.
    I use foreign keys and another tables for implement my logic
    */
    private int customerId;
    private double price;
    private int amount;
    private String description;
    private double totalAmount;

    public Order(int customerId, double price, int amount, String description) {
        this.id = i.incrementAndGet();
        this.customerId = customerId;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.totalAmount = amount * price;
    }



    // Getter and Setters
    //********************************************************************************************************************

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

package service;

import model.*;
import model.Observer;

import java.util.*;
import java.util.stream.Collectors;

public class InvoiceService implements Observer {

    private final List<Invoice> invoices;
    private final List<Customer> customers;
    private final List<Order> orders;


    public InvoiceService(List<Invoice> invoices, List<Customer> customers, List<Order> orders) {
        this.invoices = invoices;
        this.customers = customers;
        this.orders = orders;
    }

    @Override
    public void update(Order order) {
        Customer customer = customers.stream().filter(customer1 -> customer1.getId() == order.getCustomerId()).findFirst().get();
        invoices.add(new Invoice(customer,order));
    }

    public void displayAllInvoices() {
        invoices.stream().forEach(System.out::println);
    }

    public void getTotalPriceOfInvoicesByMonth(Month month) {
        double sum = customers.stream()
                .filter(customer -> customer.getMonthOfRegister() == month)
                .flatMapToDouble(customer -> orders.stream()
                                .filter(order -> customer.getId() == order.getCustomerId())
                                .mapToDouble(Order::getTotalPrice))
                .sum();

        System.out.println("Total invoice price of customers who registered on " + month.toString() + ": " + sum + " TL");
    }

    public void displayInvoiceOverGivenAmount(double amount) {
        invoices.stream().filter(invoice -> invoice.getOrder().getTotalPrice() >= amount).forEach(System.out::println);
    }

    public void displayAverageOfInvoiceOverGivenAmount(double amount) {

        OptionalDouble avg = orders.stream().filter(order -> order.getTotalPrice() >= amount).mapToDouble(Order::getTotalPrice).average();
        if (avg.isPresent()) {
            double average = avg.getAsDouble();
            System.out.println("Average: " + average);
        } else {
            System.out.println("No orders available");
        }
    }

    public void displayCustomerNamesBelowGivenAmount(double amount) {

        invoices.stream().filter(invoice -> invoice.getOrder().getTotalPrice() < amount)
                .map(invoice -> invoice.getCustomer().getName())
                .collect(Collectors.toSet())
                .forEach(System.out::println);


    }

    // Write the code that lists the companies in which the average invoices for the given month are below given amount.
    public void listOfSectors(double amount, Month month){
         invoices.stream().filter(invoice -> invoice.getCustomer().getMonthOfRegister().equals(month))
                .collect(Collectors.groupingBy(invoices -> invoices.getCustomer().getId()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().stream()
                        .mapToDouble(inv -> inv.getOrder().getTotalPrice())
                        .average()
                        .orElse(0) < amount)
                .map(entry -> customers.stream()
                        .filter(customer -> customer.getId() == entry.getKey())
                        .map(customer -> customer.getCompany().getSector())
                        .findFirst()
                        .orElse(""))
                .collect(Collectors.toSet()).forEach(System.out::println);

    }
}

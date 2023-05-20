package service;

import model.Customer;

import java.util.List;

public class CustomerService {

    private final List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void displayAllCustomers() {
        customers.stream().forEach(System.out::println);

    }
    public void displayCustomersByContainsSpecificLetter(String letter){

        customers.stream().filter(customer -> customer.getName().toLowerCase().contains(letter.toLowerCase())
                || customer.getSurname().toLowerCase().contains(letter.toLowerCase()))
                .forEach(System.out::println);
    }


}

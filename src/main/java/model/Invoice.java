package model;

public class Invoice  {
    private Customer customer;
    private Order order;
    private Company company;

    public Invoice(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
        this.company = customer.getCompany();
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return customer.toString()+"\nOrder Details\n"+order.toString();
    }
}

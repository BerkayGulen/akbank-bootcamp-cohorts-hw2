import model.*;
import service.CompanyService;
import service.CustomerService;
import service.InvoiceService;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        These 3 lists are serve as db tables.
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();


        CustomerService customerService = new CustomerService(customers);
        CompanyService companyService = new CompanyService(companies);
        OrderService orderService = new OrderService(orders);
        InvoiceService invoiceService = new InvoiceService(invoices,customers,orders);

        orderService.attach(invoiceService);



        // I add some dummy data serve as db entries...

        // First I create a company table because, Since I'm simulating a billing company,
        // I need to know the companies and their sectors.


        Company akbank = new Company("Akbank", "Banking");
        companyService.addCompany(akbank);

        Company migros = new Company("Migros", "Food");
        companyService.addCompany(migros);

        Company microsoft = new Company("Microsoft", "Information Technology");
        companyService.addCompany(microsoft);


        // I create some dummy customers
        customerService.addCustomer(new Customer("Berkay", "Gülen", 23, Month.JUNE, akbank));
        customerService.addCustomer(new Customer("Lebron", "James", 37, Month.JUNE, microsoft));
        customerService.addCustomer(new Customer("Kyrie", "Irving", 31, Month.OCTOBER, migros));
        customerService.addCustomer(new Customer("Stephen", "Curry", 33, Month.JANUARY, microsoft));


        orderService.addOrder(new Order(1, 10.0, 5, "phone"));
        orderService.addOrder(new Order(1, 15.0, 2, "tv"));
        orderService.addOrder(new Order(2, 50, 2, "ball"));
        orderService.addOrder(new Order(3, 500, 2, "laptop"));

        //Display all customers
        customerService.displayAllCustomers();

        //List customers with the letter 'C' in them
        customerService.displayCustomersByContainsSpecificLetter("B");

        //List the total amount of invoices for customers who signed up in June
        invoiceService.getTotalPriceOfInvoicesByMonth(Month.JUNE);

        //List all invoices in the system
        invoiceService.displayAllInvoices();

        //List invoices over 1500TL in the system
        invoiceService.displayInvoiceOverGivenAmount(1500);

        //Calculate the average of invoices over 1500TL in the system
        invoiceService.displayAverageOfInvoiceOverGivenAmount(1500);

        //List the names of customers with invoices under 500TL in the system
        invoiceService.displayCustomerNamesBelowGivenAmount(500);

        //Write the code that lists the companies in which the average invoices for the month of June are below 750.
        invoiceService.listOfSectors(1000,Month.JUNE);








    }
}

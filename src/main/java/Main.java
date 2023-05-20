import model.*;
import service.CompanyService;
import service.CustomerService;
import service.InvoiceService;
import service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        These 4 lists are serve as db tables.
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        // My services for filtering and data input.
        // I used observer pattern for update the invoice db when an order is created by customer.
        // Since I am simulating an invoice system, I need to know customers and their orders.
        // Also, I need to track orders so when an order created, my invoice system got notified and I create an invoice for
        // corresponding customer and his/her order.
        CustomerService customerService = new CustomerService(customers);
        CompanyService companyService = new CompanyService(companies);
        OrderService orderService = new OrderService(orders);
        InvoiceService invoiceService = new InvoiceService(invoices,customers,orders);

        orderService.attach(invoiceService);



        // I add some dummy data serve as db entries...

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

        customerService.addCustomer(new Customer("Michael ", "Jordan", 60, Month.SEPTEMBER, akbank));



        orderService.addOrder(new Order(1, 10, 3, "phone"));
        orderService.addOrder(new Order(1, 15.0, 2, "tv"));

        orderService.addOrder(new Order(2, 50, 2, "ball"));

        orderService.addOrder(new Order(3, 5000, 2, "laptop"));

        orderService.addOrder(new Order(4, 100, 2, "T-shirt"));
        orderService.addOrder(new Order(4, 10000, 1, "Car"));

        orderService.addOrder(new Order(5, 100000, 1, "House"));




        //Display all customers
        System.out.println("***************************************************************************************");
        System.out.println("\tDisplay all customers");
        customerService.displayAllCustomers();

        //List customers with the letter 'C' in them
        System.out.println("***************************************************************************************");
        System.out.println("\tList customers with the letter 'C' in them");
        customerService.displayCustomersByContainsSpecificLetter("C");

        //List the total amount of invoices for customers who signed up in June
        System.out.println("***************************************************************************************");
        System.out.println("\tList the total amount of invoices for customers who signed up in June");
        invoiceService.getTotalPriceOfInvoicesByMonth(Month.JUNE);

        //List all invoices in the system
        System.out.println("***************************************************************************************");
        System.out.println("\tList all invoices in the system");
        invoiceService.displayAllInvoices();

        //List invoices over 1500TL in the system
        System.out.println("***************************************************************************************");
        System.out.println("\tList invoices over 1500TL in the system");
        invoiceService.displayInvoiceOverGivenAmount(1500);

        //Calculate the average of invoices over 1500TL in the system
        System.out.println("***************************************************************************************");
        System.out.println("\tCalculate the average of invoices over 1500TL in the system");
        invoiceService.displayAverageOfInvoiceOverGivenAmount(1500);

        //List the names of customers with invoices under 500TL in the system
        System.out.println("***************************************************************************************");
        System.out.println("\tList the names of customers with invoices under 500TL in the system");
        invoiceService.displayCustomerNamesBelowGivenAmount(500);

        //Write the code that lists the companies in which the average invoices for the month of June are below 750.
        System.out.println("***************************************************************************************");
        System.out.println("\tWrite the code that lists the companies in which the average invoices for the month of June are below 750.");
        invoiceService.listOfSectors(1000,Month.JUNE);








    }
}

import model.Company;
import model.Customer;
import model.Month;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        These 3 lists are serve as db tables.
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Company> companies = new ArrayList<>();

        // I add some dummy data serve as db entries...

        // First I create a company table because companies are
        companies.add(new Company("Akbank", "Banking"));
        companies.add(new Company("Migros", "Food"));
        companies.add(new Company("Microsoft", "Information Technology"));

        // I create some dummy customers
        customers.add(new Customer("Berkay", "Gülen", 23, Month.MAY, 1));
        customers.add(new Customer("Lebron", "James", 50, Month.MAY, 1));
        customers.add(new Customer("Kyrie", "Irving", 17, Month.OCTOBER, 2));
        customers.add(new Customer("Stephen", "Curry", 17, Month.JANUARY, 3));


        orders.add(new Order(1, 10.0, 5, "phone"));
        orders.add(new Order(1, 15.0, 2, "tv"));
        orders.add(new Order(2, 50, 2, "ball"));
        orders.add(new Order(3, 500, 2, "laptop"));




    }
}

package service;
import model.*;
import java.util.ArrayList;
import java.util.List;


public class OrderService implements AbstractOrderService {
    private final List<Order> orders;
    private List<Observer> observers;


    public OrderService(List<Order> orders) {
        this.orders = orders;
        this.observers = new ArrayList<>();

    }

    public void addOrder(Order order){
        orders.add(order);
        notifyInvoiceService(order);
    }


    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyInvoiceService(Order order) {
        observers.stream().forEach(observer -> observer.update(order));
    }
}

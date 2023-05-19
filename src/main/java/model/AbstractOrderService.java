package model;

public interface AbstractOrderService {
    void attach(Observer o);
    void detach(Observer o);
    void notifyInvoiceService(Order order);
}

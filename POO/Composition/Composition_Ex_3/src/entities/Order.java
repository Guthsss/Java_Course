package entities;

import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDate moment;

    private OrderStatus orderStatus;
    private Client client;
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Order(LocalDate moment, OrderStatus orderStatus, Client client) {
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public void addItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        orderItemList.remove(orderItem);
    }

    public Double total() {

    }

}

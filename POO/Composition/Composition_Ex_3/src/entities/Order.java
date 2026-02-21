package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDateTime moment;

    private OrderStatus orderStatus;
    private Client client;
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Order(LocalDateTime moment, OrderStatus orderStatus, Client client) {
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void addItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        orderItemList.remove(orderItem);
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ").append(moment.format(fmt)).append("\n");
        sb.append("Order status: ").append(orderStatus).append("\n");
        sb.append(client).append("\n");
        sb.append("Order items:\n");

        for (OrderItem item : orderItemList) {
            sb.append(item.getProduct().getName() + ", ");
            sb.append("Quantity: " + item.getQuantity() + ", ");
            sb.append("Subtotal: " + item.subTotal() + "\n");

        }

        sb.append("Total price: $").append(String.format("%.2f", total()));
        return sb.toString();
    }

    public Double total() {
        double sum = 0.0;
        for (OrderItem item : orderItemList) {
            sum += item.subTotal();
        }
        return sum;


    }

}

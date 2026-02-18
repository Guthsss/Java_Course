package application;

import entities.Order;
import entities.enums.OrderStatus;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Order order = new Order(1080, new Date(), OrderStatus.PROCESSING);

        System.out.println(order);

        OrderStatus or1 = OrderStatus.DELIVERED;

        OrderStatus or2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(or1);
        System.out.println(or2);
    }
}

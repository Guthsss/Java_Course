package entities;

import java.util.PrimitiveIterator;

public class OrderItem {

    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Double subTotal () {
        return 0.0;
    }
}

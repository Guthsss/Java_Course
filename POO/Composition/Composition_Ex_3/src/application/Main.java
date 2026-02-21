package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Order order;
        OrderItem orderItem = null;
        Product product;


        System.out.println("Enter a cliente data: ");

        System.out.print("Name: ");
        String clientName = input.nextLine();

        System.out.print("Email: ");
        String clientEmail = input.next();

        System.out.print("Birth date: ");
        LocalDate clientBirthDate = LocalDate.parse(input.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Enter order data: ");

        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(input.next());

        order = new Order(LocalDateTime.now(), orderStatus, client);

        System.out.print("How may items to this order?");
        int n = input.nextInt();
        input.nextLine();

        for (int i = 0; i < n;i ++) {

            System.out.println("Enter #" + (i + 1) + " item data:");

            System.out.print("Product name: ");
            String productName = input.nextLine();

            System.out.print("Product price: ");
            double productPrice = input.nextDouble();

            product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int quantity = input.nextInt();
            input.nextLine();

            order.addItem(orderItem = new OrderItem(quantity, productPrice, product));
        }
        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);

        input.close();
    }
}

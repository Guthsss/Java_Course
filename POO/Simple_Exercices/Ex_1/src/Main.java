import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Product Data");
        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Price: ");
        double price = input.nextDouble();

        System.out.print("Quantity in stock: ");
        int quantityInStock = input.nextInt();

        Product product = new Product(name, price, quantityInStock);
        System.out.println("Product Data: " + name + ", " + price + ", " + product.getQuantity() + ", Total: $" + (price * product.getQuantity()));

        System.out.print("Enter the number of products to be added in stock: ");
        int numberOfProducts = input.nextInt();
        product.AddProduct(numberOfProducts);
        System.out.println("Update Data: " + name + ", " + price + ", " + product.getQuantity() + ", Total: $" + (price * product.getQuantity()));

        System.out.print("Enter the number of procuts to be remove in stock: ");
        int numberOfProcuts = input.nextInt();
        product.RemoveProduct(numberOfProcuts);
        System.out.println("Update Data: " + name + ", " + price + ", " + product.getQuantity() + ", Total: $" + (price * product.getQuantity()));



    }
}
package application;

import entities.ImportProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("Product #" + i + " data");

            System.out.print("Common, user or imported (c/u/i)? ");
            String cui = input.next();

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Price: ");
            Double price = input.nextDouble();

            if (cui.equalsIgnoreCase("i")) {
                System.out.print("Customs fee: ");
                Double customs = input.nextDouble();

                productList.add(new ImportProduct(name, price, customs));
            } else if (cui.equalsIgnoreCase("u")) {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(input.next(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                productList.add(new UsedProduct(name, price, manufactureDate));
            } else if (cui.equalsIgnoreCase("c")){
                productList.add(new Product(name, price));
            } else {
                System.out.println("Tipo inválido. Difite c, u ou i");
                i--;
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product product : productList) {
            System.out.println(product.priceTag());
        }
    }
}

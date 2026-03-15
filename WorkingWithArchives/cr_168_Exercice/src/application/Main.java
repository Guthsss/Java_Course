package application;

import entities.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        boolean success = new File("/home/guths/Downloads" + "/out").mkdirs();
        if (!success) {
            System.out.println("Diretório já existe ou não pôde ser criado.");
        }

        for (int i = 0; i < 4; i++) {
            try {
                String[] parts = input.nextLine().split(",");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Entrada inválida: deve ter nome,preço,quantidade");
                }
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].replace(",", "."));
                int quantity = Integer.parseInt(parts[2].trim());

                productList.add(new Product(name, price, quantity));
            } catch (Exception e) {
                System.out.println("Erro na entrada do produto " + (i + 1) + ": " + e.getMessage());
                i--; // Repetir a entrada
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/guths/Downloads/out/summary.csv"))) {
            for (Product product : productList) {
                bufferedWriter.write(product.getName() + "," + product.getPrice() + "," +
                        product.getQuantity());
                bufferedWriter.newLine();
            }

        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            input.close();
        }

    }
}

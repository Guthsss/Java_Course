package application;

import entities.Company;
import entities.Individual;
import entities.TaxPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<TaxPlayer> taxPlayerList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        short n = input.nextShort();

        for (int i = 0; i < n; i++) {
            System.out.printf("Tax payer #%d data:\n", (i + 1));

            System.out.print("Individual or Company (i/c)? ");
            char option = input.next().toLowerCase().charAt(0);
            input.nextLine();

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("AnualIncome: ");
            Double anualIncome = input.nextDouble();

            if (option == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = input.nextDouble();
                input.nextLine();

                taxPlayerList.add(new Individual(name, anualIncome, healthExpenditures));
            } else if (option == 'c'){
                System.out.print("Number of emoployees: ");
                int employees = input.nextInt();
                input.nextLine();

                taxPlayerList.add(new Company(name, anualIncome, employees));
            } else {
                System.out.println("Invalid option");
                i--;
            }
        }
        System.out.println();
        System.out.println("TAXES PAID");

        Double sum = 0.0;
        for (TaxPlayer taxPlayer : taxPlayerList) {
            System.out.println(taxPlayer.getName() + ": $ " + String.format("%.2f", taxPlayer.tax()));
            sum += taxPlayer.tax();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

        input.close();
    }
}

package applicaton;

import model.Expedicion.DomainExpedicion;
import model.entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Enter account data: ");

            System.out.print("Number: ");
            int number = input.nextInt();
            input.nextLine();

            System.out.print("Holder: ");
            String holder = input.nextLine();

            System.out.print("Initial balance: ");
            Double initialBalance = input.nextDouble();

            System.out.print("Withdraw limit: ");
            Double withdrawlimit = input.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdrawlimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            account.withdraw(input.nextDouble());

            System.out.println("New balance: " + account.getBalance());
        } catch (DomainExpedicion e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
    }
}

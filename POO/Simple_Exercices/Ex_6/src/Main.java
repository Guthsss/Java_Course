import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int number = input.nextInt();
        input.nextLine();
        System.out.print("Enter account holder: ");
        String holder = input.nextLine();
        System.out.print("Is there na initial deposit (Y/N): ");
        String response = input.nextLine();
        Account account;
        if (response.equalsIgnoreCase("y")) {
            System.out.print("Enter initial deposit value: ");
            double money = input.nextDouble();
            account = new Account(number, holder, money);
        } else if (response.equalsIgnoreCase("n")) {
            account = new Account(number, holder);
        } else {
            System.out.println("Invalid");
            input.close();
            return;
        }
        System.out.println("Account Data: ");
        account.toString();
        System.out.println(account);

        System.out.println("Enter a deposit value: ");
        double money = input.nextDouble();
        account.deposit(money);
        System.out.println("Updated account data: ");
        System.out.println(account);

        System.out.println("Enter a withdraw value: ");
        money = input.nextDouble();
        account.withdraw(money);
        System.out.println(account);



    }
}

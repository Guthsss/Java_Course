package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        //Account account = new Account(1000, "Alex", 1000.0); n posso por ser uma classe abstrata;
        //Account account1 = new BusinessAccount(1001, "Gregory", 1020.0, 0.10);
        //Account account2 = new SavingAccount(1003, "Roberta", 2000.0, 200.0);

        List<Account> accountList = new ArrayList<>();

        accountList.add(new SavingAccount(1001, "Tobe", 1000.0, 0.01));
        accountList.add(new SavingAccount(1002, "Andressa", 1200.0, 0.03));
        accountList.add(new BusinessAccount(1003, "Sabrina", 1500.0, 500.0));
        accountList.add(new BusinessAccount(1004, "Ana", 1200.0, 1000.0));



        double sum = 0.0;
        for (Account a : accountList) {
            sum += a.getBalance();
        }
        System.out.println("Total Balance: " + sum);

        for (Account a : accountList) {
            a.deposit(100.0);
        }
        for (Account a : accountList) {
            System.out.printf("Update Balance for account %d: %.2f%n", a.getNumber(), a.getBalance());
        }
    }
}

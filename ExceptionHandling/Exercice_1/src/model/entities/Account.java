package model.entities;

import model.Expedicion.DomainExpedicion;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws DomainExpedicion {
        if (balance < 0) {
            throw new DomainExpedicion("balance must be positive");
        }
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) throws DomainExpedicion {
        if (balance < amount) {
            throw new DomainExpedicion("not enough balance");
        } else if (withdrawLimit < amount) {
            throw new DomainExpedicion("The amount exceeds withdraw limit");
        }
        balance -= amount;
    }

    public Double getBalance() {
        return balance;
    }
}


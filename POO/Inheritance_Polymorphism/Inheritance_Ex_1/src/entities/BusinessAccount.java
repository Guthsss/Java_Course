package entities;

public class BusinessAccount extends Account {

    private Double loanLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount) {
        // Exemplo de regra de negócio:
        // pode emprestar até o limite, e cobra taxa fixa de 10.0
        if (amount <= loanLimit) {
            balance += amount - 10.0;
        }
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    @Override
    public void withdraw(Double amount) {
        // Exemplo de polimorfismo:
        // BusinessAccount cobra uma taxa extra no saque
        double fee = 2.0;
        balance -= amount + fee;
    }
}
package entities;

public class SavingAccount extends Account {

    private Double interestRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        // Atualiza o saldo aplicando juros (ex.: 2% => interestRate = 0.02)
        balance += balance * interestRate;
    }

    @Override
    public void withdraw(Double amount) {
        // Exemplo de polimorfismo:
        // SavingAccount não cobra taxa extra (ou pode ter outra regra)
        balance -= amount;
    }
}
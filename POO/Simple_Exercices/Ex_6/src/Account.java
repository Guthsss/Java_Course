public class Account {
    private int accountNumber;
    private String holder;
    private double money;

    public Account(int accountNumber, String holder, double inicialDeposit) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        deposit(inicialDeposit);
    }
    public Account(int accountNumber, String holder) {
        this.accountNumber = accountNumber;
        this.holder = holder;
    }
    public double deposit(double money) {
        return this.money += money;
    }
    public double withdraw(double money) {
        return this.money -= (money + 5.0);
    }
    public String getHolder() {
        return holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getMoney() {
        return money;
    }
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", holder='" + holder + '\'' +
                ", money=" + money +
                '}';
    }
}

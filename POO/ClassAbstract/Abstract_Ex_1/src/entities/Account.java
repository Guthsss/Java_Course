package entities;

/**
 * Superclasse (classe base) do modelo de contas.
 *
 * Ideia principal:
 * - Account define o "contrato" comum (dados e operações básicas).
 * - Subclasses (ex.: BusinessAccount, SavingAccount) especializam regras.
 *
 * Observação importante sobre OO:
 * - Upcasting: você pode guardar um objeto de subclasse em uma variável Account.
 *   O objeto continua sendo da subclasse, mas a variável "enxerga" apenas o que
 *   existe em Account (a não ser que você faça downcasting).
 */
public abstract class Account {

    private Integer number;
    private String holder;

    /**
     * protected permite que subclasses acessem diretamente.
     *
     * Em projetos maiores, muitas vezes é preferível manter privado e
     * manipular via métodos (get/set/regras), mas aqui o protected facilita
     * o exemplo de herança/polimorfismo (loan/updateBalance alterando saldo).
     */
    protected Double balance;

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Account() {
    }

    /**
     * Saque.
     *
     * Regra padrão da classe base:
     * - apenas subtrai o valor do saldo.
     *
     * Polimorfismo:
     * - subclasses podem sobrescrever este método para aplicar taxas/regras
     *   diferentes (ex.: BusinessAccount cobrar taxa extra).
     */
    public void withdraw(Double amount) {
        balance -= amount;
    }

    /**
     * Depósito.
     *
     * Regra padrão:
     * - soma o valor ao saldo.
     */
    public void deposit(Double amount) {
        balance += amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    /**
     * Getter do saldo.
     * Note que não há setter: a intenção é alterar saldo por operações (deposit/withdraw)
     * ou regras específicas nas subclasses.
     */
    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                '}';
    }
}
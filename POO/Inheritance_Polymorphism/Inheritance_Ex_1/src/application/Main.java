package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Account account = new Account(1001, "Alex", 0.0);
        BusinessAccount businessAccount = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // ---------------------------------------------------------------------
        // UPCASTING (subclasse -> superclasse)
        // ---------------------------------------------------------------------
        // O OBJETO continua sendo BusinessAccount.
        // O que muda é apenas o TIPO da REFERÊNCIA (variável), que agora é Account.
        Account account1 = businessAccount;

        // Aqui você consegue acessar só o que existe em Account (tipo da variável):
        account1.deposit(50.0);
        account1.withdraw(10.0);

        // NÃO compila (porque Account não tem loan/getLoanLimit):
        // account1.loan(100.0);
        // System.out.println(account1.getLoanLimit());

        System.out.println("account1 (referência Account apontando p/ BusinessAccount): " + account1);

        Account account2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        System.out.println("account2 (criando BusinessAccount em variável Account): " + account2);

        Account account3 = new SavingAccount(1004, "Gregory", 0.0, 0.02);
        System.out.println("account3 (criando SavingAccount em variável Account): " + account3);

        // ---------------------------------------------------------------------
        // POLIMORFISMO (método sobrescrito executa conforme o TIPO REAL do objeto)
        // ---------------------------------------------------------------------
        // Mesmo a variável sendo Account, o método executado pode ser o "withdraw"
        // sobrescrito nas subclasses.
        account2.deposit(200.0);
        account2.withdraw(50.0); // chama withdraw de BusinessAccount (se sobrescrito)
        System.out.println("Após withdraw em account2: " + account2);

        account3.deposit(200.0);
        account3.withdraw(50.0); // chama withdraw de SavingAccount (se sobrescrito)
        System.out.println("Após withdraw em account3: " + account3);

        // ---------------------------------------------------------------------
        // DOWNCASTING (superclasse -> subclasse)
        // ---------------------------------------------------------------------
        // Só faz sentido quando você tem CERTEZA do tipo real do objeto.
        BusinessAccount account4 = (BusinessAccount) account2; // OK: account2 é BusinessAccount
        account4.loan(100.0);
        System.out.println("Após loan em account4: " + account4);

        // ERRO em tempo de execução (ClassCastException) se descomentar:
        // BusinessAccount badCast = (BusinessAccount) account3;

        // Forma segura: verificar com instanceof antes (Java 21: pattern matching)
        if (account3 instanceof BusinessAccount ba) {
            ba.loan(200.0);
            System.out.println("Loan! (account3 era BusinessAccount)");
        } else {
            System.out.println("account3 NÃO é BusinessAccount, então não dá para loan()");
        }

        if (account3 instanceof SavingAccount sa) {
            sa.updateBalance();
            System.out.println("Update! (account3 era SavingAccount)");
            System.out.println("Após updateBalance: " + sa);
        }

        // ---------------------------------------------------------------------
        // MAIS EXEMPLOS ÚTEIS
        // ---------------------------------------------------------------------

        // Exemplo 1: lista polimórfica (uma lista de Account pode guardar subclasses)
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(2001, "Ana", 100.0));
        accounts.add(new BusinessAccount(2002, "Bruno", 100.0, 300.0));
        accounts.add(new SavingAccount(2003, "Carla", 100.0, 0.01));

        // Tratar tudo como Account (interface comum)
        for (Account acc : accounts) {
            acc.deposit(10.0);
            acc.withdraw(5.0); // cada tipo pode cobrar taxa diferente (polimorfismo)
        }

        // Exemplo 2: comportamento específico quando precisar (com instanceof)
        for (Account acc : accounts) {
            if (acc instanceof BusinessAccount ba) {
                ba.loan(50.0);
            } else if (acc instanceof SavingAccount sa) {
                sa.updateBalance();
            }
        }

        // Exemplo 3: método que recebe a superclasse (aceita qualquer subclasse)
        applyMonthlyUpdate(accounts);

        System.out.println("\n--- Estado final ---");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }

    /**
     * Exemplo: um método que trabalha com a superclasse.
     * - Ele consegue executar operações comuns (deposit/withdraw).
     * - Se precisar de algo específico, usa instanceof com downcasting seguro.
     */
    private static void applyMonthlyUpdate(List<Account> accounts) {
        for (Account acc : accounts) {
            // operação comum
            acc.deposit(1.0);

            // operação específica
            if (acc instanceof SavingAccount sa) {
                sa.updateBalance();
            }
        }
    }
}
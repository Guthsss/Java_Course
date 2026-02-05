import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        var input = new Scanner(System.in);
        System.out.println("What is the dollar price? ");
        double dollarPrice = input.nextDouble();
        System.out.println("How many dollars will be bought? ");
        double dollars = input.nextDouble();
        System.out.println("Amount to be paid in reias = " + String.format("%.2f" , CurrencyConverter.convert(dollarPrice, dollars)));
    }
}

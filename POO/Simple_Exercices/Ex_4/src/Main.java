import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        var input = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        double radius = input.nextDouble();
        System.out.printf("Circumference: %.2f%n", Calculator.circuference(radius));
        System.out.printf("Volume: %.2f%n", Calculator.volume(radius));
        System.out.printf("PI: value: %.2f%n", Calculator.PI);
    }
}

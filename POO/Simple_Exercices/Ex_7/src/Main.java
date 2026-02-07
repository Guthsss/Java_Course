import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product;
        Locale.setDefault(Locale.US);
        var imput = new Scanner(System.in);
        System.out.print("Quantity of products: ");
        int n = imput.nextInt();
        imput.nextLine();
        System.out.println("");
        Product[] array = new Product[n];
        for (int i = 0;i<n; i++) {
            System.out.print("Enter the product name: ");
            String name = imput.nextLine();
            System.out.print("Enter the product price: ");
            double price = imput.nextDouble();
            imput.nextLine();
            product = new Product(name, price);
            array[i] = product;
        }
        double sum = 0.0;
        for (int i = 0;i<n; i++) {
            sum += array[i].getPrice();
        }
        double avg = sum / n;
        for (int i = 0;i<n; i++) {
            System.out.println(array[i]);
        }
        System.out.println(avg);
    }
}

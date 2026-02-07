package Simple_Exercices;

import java.util.Locale;
import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        var input = new Scanner(System.in);
        System.out.print("How many numbers are you going to type: ");
        int numberQuantity = input.nextInt();
        if (numberQuantity > 10) {
            System.out.print("Error");
            System.exit(0);
        }
        double[] array = new double[numberQuantity];
        for (int i = 0; i<array.length;i++) {
            System.out.print("Enter a number: ");
            double numbers = input.nextDouble();
            array[i] = numbers;
        }
        System.out.println("Negative numbers: ");
        for (double num: array) {
            if (num < 0) {
                System.out.println(num);
            }
        }
        input.close();
    }
}

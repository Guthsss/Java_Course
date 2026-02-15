package Simple_Exercices;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Ex_4 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers will you type: ");
        int n = input.nextInt();
        double[] array = new double[n];
        for (int i=0;i<array.length;i++) {
            System.out.print("Enter a number: ");
            double number = input.nextDouble();
            array[i] = number;
        }
        System.out.println(" ");
        System.out.println("Even numbers: ");
        Set<Double> printed = new HashSet<>();
        int count = 0;
        for (int i=0;i<array.length;i++) {
            if (array[i] % 2 == 0) {
                count ++;

                if (printed.add(array[i])) {
                    System.out.println(array[i]);
                }
            }
        }
        System.out.println("Number of pairs: " + count);
        input.close();
    }
}

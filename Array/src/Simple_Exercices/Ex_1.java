package Simple_Exercices;

import java.util.Locale;
import java.util.Scanner;

public class Ex_1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try(var input = new Scanner(System.in)) {
            double average_height = 0.0;
            System.out.print("Number of heights: ");
            int n = input.nextInt();
            double[] array = new double[n];
            for (int i = 0; i<n; i++) {
                System.out.print("Enter heights: ");
                double heights = input.nextDouble();
                array[i] = heights;
            }
            for (int i = 0; i<n; i++) {
                average_height += array[i];
            }
            average_height /= n;
            System.out.println(String.format("%.2f", average_height));
        }
    }
}

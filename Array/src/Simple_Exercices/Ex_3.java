package Simple_Exercices;

import java.util.Scanner;

public class Ex_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers are you going to type: ");
        int n = input.nextInt();
        double[] array = new double[n];
        double sum = 0.0;
        for (int i = 0; i< array.length; i++) {
            System.out.print("Enter a number: ");
            double number = input.nextDouble();
            array[i] = number;
            sum += array[i];
        }
        System.out.println("");
        System.out.print("Values: ");
        for (int i = 0; i< array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nSum: " + sum);
        System.out.println("Avg: " + sum/ array.length);
    }
}

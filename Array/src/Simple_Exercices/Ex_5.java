package Simple_Exercices;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Ex_5 {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] array = new int[n][n];
        System.out.println("Main diagonal:");
        int count = 0;
        for (int i = 0;i < array.length;i++) {
            for (int j = 0; j < array[i].length;j++) {
                array[i][j] = randomGenerator.nextInt(-30, 30);
            }
        }
        for (int i = 0;i < array.length;i++) {
            for (int j = 0; j < array[i].length;j++) {
                 if (i == j) {
                     System.out.println(array[i][j]);
                 } else if (array[i][j] < 0) {
                     count ++;
                 }
            }
        }
        System.out.printf("Negative numbers: %d%n", count);
    }
}

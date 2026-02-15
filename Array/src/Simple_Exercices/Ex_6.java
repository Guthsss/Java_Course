package Simple_Exercices;

import java.util.Scanner;

public class Ex_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0;i < mat.length; i++) {
            for (int j = 0; j< mat[i].length; j++) {
                mat[i][j]= input.nextInt();
            }
        }
        int x = input.nextInt();
        for (int i = 0;i < mat.length; i++) {
            for (int j = 0; j< mat[i].length; j++) {
                if (mat[i][j] == x) {
                    System.out.printf("Position: %d, %d%n",i , j);
                    if (j > 0) {
                        System.out.println("Left: " + mat[i][j - 1]);
                    }
                    if (j < mat[i].length - 1) {
                        System.out.println("Right: " + mat[i][j + 1]);
                    }
                    if (i > 0) {
                        System.out.println("Up: " + mat[i - 1][j]);
                    }
                    if (i < mat.length - 1) {
                        System.out.println("Down: " + mat[i + 1][j]);
                    }
                }
            }
        }

        input.close();
    }
}

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex_1 {
    public static void main(String[] args) {

        method1();

        System.out.println("End of program");

    }
    public static void method1() {
        System.out.println("***METHOD1 INICIANDO***");
        method2();
        System.out.println("***METHOD1 FECHANDO");
    }
    public static void method2() {
        Scanner input = new Scanner(System.in);
        System.out.println("***METHOD2 INICIANDO***");


        try {
            String[] vect = input.nextLine().split(" ");
            int position = input.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position");
            e.printStackTrace();
            input.next();
        } catch (InputMismatchException e) {
            System.out.println("Input error");
            e.printStackTrace();
            input.next();
        }
        input.close();
        System.out.println("***METHOD2 FECHANDO***");

    }
}

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        System.out.print("How many people will be typed: ");
        int n = input.nextInt();
        input.nextLine();
        Peoples[] array = new Peoples[n];
        Peoples peoples = null;

        for (int i = 0;i< array.length;i++) {
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Age:");
            int age = input.nextInt();
            System.out.print("Height: ");
            double height = input.nextDouble();
            input.nextLine();
            array[i] = new Peoples(name, age, height);
        }
        for (Peoples p : array) {
            System.out.println(p.toString());
        }
        double sum = 0.0;
        for (Peoples p : array) {
            sum += p.getHeight();
        }
        System.out.println(" ");
        System.out.println("Average height: " + sum/n);
        double under16 = 0.0;
        for (Peoples p : array) {
            if (p.getAge() < 16) {
                under16 += 1;
            }
        }
        System.out.println("% " + (under16/n) * 100);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("GrossSalary: ");
        double grossSalary = input.nextDouble();
        System.out.print("Tax: ");
        double tax = input.nextDouble();

        Employee employee = new Employee(tax, grossSalary, name);

        System.out.println(employee);
        System.out.print("Whith percentage to increase salary: ");
        double percentage = input.nextDouble();

        employee.IncreaseSalary(percentage);


        System.out.println("Updated data: " + name + ", $ " + employee.NetSalary());
    }
}

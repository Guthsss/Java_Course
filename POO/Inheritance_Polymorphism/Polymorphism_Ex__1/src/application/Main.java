package application;

import entities.Employee;
import entities.OutsoucedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = input.nextInt();

        for (int i = 0;i < n; i++) {
            System.out.println("Employee #" + (i+1) + " data:");

            System.out.print("Outsourced (y/n)? ");
            String outSouced = input.next();
            input.nextLine();

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Hours: ");
            int hours = input.nextInt();

            System.out.print("Hourly rate: ");
            Double valuePerHour = input.nextDouble();

            if (outSouced.equalsIgnoreCase("y")) {
                System.out.print("Additional charge: ");
                employeeList.add(new OutsoucedEmployee(name, valuePerHour, hours, input.nextDouble()););
            } else {
                employeeList.add(new Employee(name, valuePerHour, hours););
            }

        }
        System.out.println();
        System.out.println("PAYMENTS:");

        for (Employee e : employeeList) {
            System.out.println(e.getName() + " - $ " + e.payment());
        }

    }
}

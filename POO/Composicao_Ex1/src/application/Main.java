package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Department department = null;
        HourContract hourContract = null;
        Worker worker = null;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter department´s name: " );
        String nameDepartment = input.nextLine();

        department = new Department(nameDepartment);

        System.out.print("Enter worker data:");
        System.out.println(" ");

        System.out.print("Name: ");
        String nameWorker = input.nextLine();

        System.out.print("Level: ");
        String wlS = input.next();
        WorkerLevel wl = WorkerLevel.valueOf(wlS);

        System.out.print("Base salary: ");
        Double baseSalary = input.nextDouble();
        System.out.println(" ");

        worker = new Worker(nameWorker, wl, baseSalary);

        System.out.print("How many contracts to this worker? ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter contract #%d data:", (i + 1));
            System.out.println(" ");

            System.out.print("Date (DD/MM/YYYY)");
            String date = input.next();
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Value per hour: ");
            double valuePerHour = input.nextInt();

            System.out.print("Duration: ");
            Integer hour = input.nextInt();

            worker.addContract(new HourContract(localDate, valuePerHour, hour));
        }

        System.out.println("Enter a month and year to calculate income (MM/YYYY)");
        String month = input.next();
        YearMonth ym = YearMonth.parse(month, DateTimeFormatter.ofPattern("MM/yyyy"));

        System.out.println("Name: " + worker.getName());
        System.out.println("Depatment: " + department.getName());
        System.out.println("Income for " + month + ": " + worker.income(ym.getYear(), ym.getMonthValue()));

    }
}

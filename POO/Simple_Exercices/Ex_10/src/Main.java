import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Employee employee = null;
        List<Employee> employees = new ArrayList<>();
        System.out.print("How may employees will be registered: ");
        int n = input.nextInt();

        for (int i = 0; i<n; i++) {
            System.out.println("Employee #" + (i+1));

            System.out.print("Id: ");
            int id = input.nextInt();
            input.nextLine();

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Salary: ");
            double salary = input.nextDouble();
            System.out.println();

            employees.add(new Employee(id, name, salary));
        }
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = input.nextInt();
        Employee found = null;
        for (Employee e : employees) {
            if (e.getId() == id) {
                found = e;
                break;
            }
        }
        if (found != null) {
            System.out.print("Enter the percentage: ");
            double percentage = input.nextDouble();
            found.salaryIncrease(percentage);
        } else {
            System.out.println("This id does not exist");
        }
        System.out.println();
        System.out.println("List of employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }


    }
}

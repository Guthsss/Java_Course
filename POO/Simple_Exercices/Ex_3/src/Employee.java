public class Employee {
    private String name;
    private double grossSalary;
    private double tax;

    public Employee(double tax, double grossSalary, String name) {
        this.tax = tax;
        this.grossSalary = grossSalary;
        this.name = name;
    }
    public double NetSalary() {
        return grossSalary - tax;
    }
    public void IncreaseSalary(double percentage) {
        grossSalary += grossSalary * (percentage/100);
    }

    @Override
    public String toString() {
        return "Employee: " + name + ",$ " + NetSalary();
    }
}

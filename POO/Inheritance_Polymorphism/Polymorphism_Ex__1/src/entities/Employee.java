package entities;

public class Employee {

    private String name;
    private Integer hours;
    private Double valuePerHour;


    public Employee() {
    }

    public Employee(String name, Double valuePerHour, Integer hours) {
        this.name = name;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Double payment() {
        return valuePerHour * hours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public String getName() {
        return name;
    }
}

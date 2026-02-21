package entities;

import java.time.LocalDate;

public class HourContract {

    private LocalDate date;
    private double valuePerHour;
    private Integer hours;


    public HourContract(LocalDate date, double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public double totalValue() {
        return hours * valuePerHour;
    }

    public LocalDate getDate() {
        return date;
    }
}

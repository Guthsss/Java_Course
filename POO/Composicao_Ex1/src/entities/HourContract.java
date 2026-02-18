package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
}

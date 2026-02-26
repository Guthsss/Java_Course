package entities;

public class OutsoucedEmployee extends Employee {

    private Double additionalCharge;

    public OutsoucedEmployee() {
        super();
    }

    public OutsoucedEmployee(String name, Double valuePerHour, Integer hours, Double additionalCharge) {
        super(name, valuePerHour, hours);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment() {
        return super.payment() + additionalCharge * 1.1;
    }

}

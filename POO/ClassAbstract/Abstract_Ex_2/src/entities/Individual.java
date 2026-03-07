package entities;

public class Individual extends TaxPlayer{

    private final Double healthExpenditures;

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        if (getAnualIncome() < 20000.00) {
            return (getAnualIncome() * 0.15) - (healthExpenditures * 0.5);
        } else {
            return (getAnualIncome() * 0.25) - (healthExpenditures * 0.5);
        }
    }
}

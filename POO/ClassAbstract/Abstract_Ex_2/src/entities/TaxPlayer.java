package entities;

public abstract class TaxPlayer {

    private String name;
    private final Double anualIncome;

    public TaxPlayer(String name, Double anualIncome) {
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public abstract Double tax();

    public Double getAnualIncome() {
        return anualIncome;
    }

    public String getName() {
        return name;
    }
}

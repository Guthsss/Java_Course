package entities;

public class ImportProduct extends Product {

    private final Double customsFee;

    public ImportProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        return getName() + " $ " + totalPrice() +
                " (Customs fee: $ " + String.format("%.2f", customsFee) + ")";
    }

    public Double totalPrice() {
        return  getPrice() + customsFee;
    }
}

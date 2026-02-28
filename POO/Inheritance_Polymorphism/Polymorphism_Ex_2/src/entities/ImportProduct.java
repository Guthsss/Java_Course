package entities;

public class ImportProduct extends Product {

    private Double customsFee;

    public ImportProduct() {
        super();
    }

    public ImportProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTang() {
        return super.priceTang();
    }

    public Double totalPrice() {
        return null;
    }
}

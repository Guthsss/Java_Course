public class Product {
    private final String nome;
    private final double price;
    private int quantity;

    public Product(String nome, double price, int quantity) {
        this.nome = nome;
        this.price = price;
        this.quantity = quantity;
    }
    public double TotalValueInStock() {
        return this.quantity * this.price;
    }
    public void AddProduct(int quantity) {
        this.quantity += quantity;
    }
    public void RemoveProduct(int quantity) {
        this.quantity -= quantity;
    }
    @Override
    public String toString() {
        return "Product{" + "nome=" + nome + ", price=" + price + ", quantity=" + quantity + '}';
    }
    public int getQuantity() {
        return quantity;
    }
}
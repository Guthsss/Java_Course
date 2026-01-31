public class Rectangle {
    private final double width;
    private final double height;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    public double Area() {
        return height * width;
    }
    public double Perimeter() {
        return (height * 2) + (width * 2);
    }
    public double Diagonal() {
        return Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
    }
}

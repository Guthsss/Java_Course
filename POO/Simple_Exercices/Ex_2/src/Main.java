import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter rectangle width and height: ");
        double width = input.nextDouble();
        double height = input.nextDouble();
        input.close();

        Rectangle rectangle = new Rectangle(height, width);

        System.out.println("AREA" + rectangle.Area());
        System.out.println("PERIMETER" + rectangle.Perimeter());
        System.out.println("DIAGONAL" + rectangle.Diagonal());
    }
}

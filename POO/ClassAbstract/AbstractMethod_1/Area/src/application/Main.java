package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        List<Shape> shapeList = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        short shapes = input.nextShort();

        for (int i = 0; i < shapes; i++) {
            System.out.printf("Shape #%d data:\n", (i + 1));

            System.out.print("Rectangle or Circle (r/c)? ");
            String option = input.next();

            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(input.next().toUpperCase());

            if (option.equalsIgnoreCase("r")) {
                System.out.print("Wigth: ");
                double width = input.nextDouble();

                System.out.print("heigth: ");
                double heigth = input.nextDouble();

                shapeList.add(new Rectangle(color, heigth, width));

            } else if (option.equalsIgnoreCase("c")) {
                System.out.print("Radious: ");
                double radious = input.nextDouble();

                shapeList.add(new Circle(color, radious));
            }
        }
        System.out.println();
        System.out.println("SHAPE AREAS");
        for (Shape shape : shapeList) {
            System.out.printf("%.2f%n", shape.area());
        }
        input.close();
    }
}

package entities;

import entities.enums.Color;

public class Circle extends Shape{

    private Double radious;

    public Circle(Color color, Double radious) {
        super(color);
        this.radious = radious;
    }

    @Override
    public Double area() {
        return Math.PI * Math.pow(radious, 2);
    }
}

package org.example;

public class Shape {
    private final String type;
    private double length;
    private double base;
    private double width;
    private double height;
    private double a;
    private double b;
    private double radius;
    String s = "circle";
    String s2 = "rectangle";
    String s3 = "triangle";

    Shape(String type, double radius) {
        this.type = type;
        this.radius = radius;
    }

    Shape(String type, double length, double width) {
        this.type = type;
        this.length = length;
        this.width = width;
    }

    Shape(String type, double base, double height, double a, double b) {
        this.type = type;
        this.height = height;
        this.base = base;
        this.a = a;
        this.b = b;
    }

    public double getPerimeter() {
        double perimeter = 0;
        if (type.equals(s3)) {
            perimeter = a + b + base;
        } else if (type.equals(s2)) {
            perimeter = 2 * (length + width);
        } else if (type.equals(s)) {
            perimeter = 2 * Math.PI * radius;
        }
        return perimeter;
    }

    public double getArea() {
        double area = 0;
        if (type.equals(s3)) {
            area = base * height * 0.5;
        } else if (type.equals(s2)) {
            area = length * width;
        } else if (type.equals(s)) {
            area = Math.PI * radius * radius;
        }
        return area;
    }
}
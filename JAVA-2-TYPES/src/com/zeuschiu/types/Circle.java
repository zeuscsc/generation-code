package com.zeuschiu.types;

public class Circle {
    public static final double PI = 3.14159265358979323846;
    private float diameter;

    public Circle(float diameter) {
        this.diameter = diameter;
    }

    public double radius() {
        return (double) diameter / 2.0;
    }

    public float area() {
        return (float) (Math.pow(radius(), 2.0) * PI);
    }

    @Override
    public String toString() {
        return String.format("Circle %s having diameter of %d and its area is %.2f", super.hashCode(), (int) diameter,
                area());
    }
}

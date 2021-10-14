package com.zeuschiu.types.test;

public class Circle {
    public static final double PI = 3.14159265358979323846;
    private float diameter=0.0f;

    public Circle(float diameter){
        this.diameter=diameter;
    }
    public float area(){
        return (float)((Math.pow((double)diameter/2.0,2))*PI);
    }
    @Override
    public String toString(){
        return String.format("Circle %s with diameter %f and its area is %f",
                super.toString(),diameter,area());
    }
}

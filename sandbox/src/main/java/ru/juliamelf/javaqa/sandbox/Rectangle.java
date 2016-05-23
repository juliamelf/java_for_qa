package ru.juliamelf.javaqa.sandbox;

/**
 * Created by korotkova on 5/23/2016.
 */
public class Rectangle {

    public double a;
    public double b;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;

    }

    public double area(){
        return this.a * this.b;
    }
}

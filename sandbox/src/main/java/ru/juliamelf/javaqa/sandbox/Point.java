package ru.juliamelf.javaqa.sandbox;

public class Point {

    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2){

        return Math.sqrt(Math.sqrt(p2.x - x) + Math.sqrt(p2.y - y));

    }
}

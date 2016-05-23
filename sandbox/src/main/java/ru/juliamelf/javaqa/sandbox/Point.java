package ru.juliamelf.javaqa.sandbox;

/**
 * Created by korotkova on 5/23/2016.
 */
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

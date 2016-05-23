package ru.juliamelf.javaqa.sandbox;

public class MyFirstProgram{

	public static void main(String[] args) {

		/*
		System.out.println("Hello, world!");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4,6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
		*/

		Point p1 = new Point(5,10);
		System.out.println("Координаты точки A: " + p1.x + ", " + p1.y);
		Point p2 = new Point(7,20);
		System.out.println("Координаты точки B: " + p2.x + ", " + p2.y);
		System.out.println("Расстояние от точки А до точки В: " + p1.distance(p2));

	}


}
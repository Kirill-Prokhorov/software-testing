package ru.stqa.software_testing.sandbox;

public class Main {

	public static void main(String[] args) {

		System.out.println("Hello, World!");

		Point p1 = new Point(7, 9);
		Point p2 = new Point(16, 10);
		System.out.println(distance(p1, p2));
		System.out.println(p1.distance(p2));
		System.out.println(p2.distance(p1));


	}

	public static double distance(Point p1, Point p2) {

		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
	}
}
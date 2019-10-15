package ru.stqa.project.sandbox;

public class HelloWorld {
  public static void main(String[] arg) {

    System.out.println("Hello, World!");

    double len1 = distance(new Point(0, 0), new Point(5, 5));
    Distance s = new Distance(new Point(2, 2), new Point(6, 8));
    double len2 = s.distance();
    System.out.println("Расстояние между точками равно " + len1);
    System.out.println("Расстояние между точками равно " + len2);
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) +
            (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
  }

}
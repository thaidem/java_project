package ru.stqa.project.sandbox;

public class Distance {

  Point p1, p2;

  public Distance(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public double distance() {

    return Math.sqrt((this.p1.getX() - this.p2.getX()) * (this.p1.getX() - this.p2.getX()) +
            (this.p1.getY() - this.p2.getY()) * (this.p1.getY() - this.p2.getY()));
  }
}

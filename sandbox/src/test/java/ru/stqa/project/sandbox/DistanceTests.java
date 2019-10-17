package ru.stqa.project.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void testArea() {

    Point p1 = new Point(2, 2);
    Assert.assertEquals(p1.distance(new Point(5, 6)),5.0);
    Point p2 = new Point(5, 6);
    Assert.assertEquals(p2.distance(new Point(10, 12)),7.810249675906654);
    Point p3 = new Point(0, 0);
    Assert.assertEquals(p3.distance(new Point(5, 5)),7.0710678118654755);

  }
}

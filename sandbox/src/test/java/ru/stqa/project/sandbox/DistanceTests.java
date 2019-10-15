package ru.stqa.project.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void testDistance() {
    Distance s = new Distance(new Point(2, 2), new Point(5, 6));
    Assert.assertEquals(s.distance(),5);
    Distance s1 = new Distance(new Point(5, 6), new Point(10, 12));
    Assert.assertEquals(s1.distance(),7.810249675906654);
    Distance s2 = new Distance(new Point(0, 0), new Point(5, 5));
    Assert.assertEquals(s2.distance(),7.0710678118654755);
  }
}

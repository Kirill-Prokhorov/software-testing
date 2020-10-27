package ru.stqa.software_testing.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(2,  4);
    Point p2 = new Point(4, 5);
    Point p3 = new Point(7, 6);
    assert p1.distance(p2) == 2.23606797749979;
    Assert.assertEquals(p1.distance(p2), 2.23606797749979);
    assert p2.distance(p3) == 3.1622776601683795;
    Assert.assertEquals(p2.distance(p3), 3.1622776601683795);


  }

}

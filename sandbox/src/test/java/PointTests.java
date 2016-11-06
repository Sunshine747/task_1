import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Администратор on 06.11.2016.
 */
public class PointTests {

  @Test
  public void testDistance() {

    Point p1 = new Point(5, 5);
    Point p2 = new Point(5, -8);

    assert p1.distance(p2) == 13;
    assert p1.distance(p1) == 0;
    assert p1.distance(p1, p2) == 13;
    assert p1.distance(p1, p1) == 0;
    assert p1.distance(p2) == p1.distance(p1, p2);
  }

  @Test
  public void testDistance2() {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(10.2, 10);


    Assert.assertEquals(p1.distance(p2), 14.284257068535275);
    Assert.assertEquals(p1.distance(p1), 0.0);
    Assert.assertEquals(p1.distance(p1, p2), 14.284257068535275);
    Assert.assertEquals(p1.distance(p1, p1), 0.0);
    Assert.assertEquals(p1.distance(p2), p1.distance(p1, p2));
  }

  @Test
  public void testDistance3() {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(10.2, 10);

    Assert.assertNotEquals(p1.distance(p2), 14.284);
    Assert.assertNotEquals(p1.distance(p1), 1);
    Assert.assertNotEquals(p1.distance(p1, p2), 14.284);
    Assert.assertNotEquals(p1.distance(p1, p1), 1);
    Assert.assertEquals(p1.distance(p2), p1.distance(p1, p2));
  }
}

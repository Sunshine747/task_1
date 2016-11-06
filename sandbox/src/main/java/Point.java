/**
 * Created by Администратор on 03.11.2016.
 */
public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p1, Point p2) {

    return Math.sqrt(Math.pow(p1.x - p2.x, 2.0) + Math.pow(p1.y - p2.y, 2.0));

  }

  public double distance(Point p2) {
    return Math.sqrt(Math.pow(this.x - p2.x, 2.0) + Math.pow(this.y - p2.y, 2.0));
  }
}
class FirstProgram {
  public static void main(String[] args) {

    Point p1 = new Point(5, 5);

    Point p2 = new Point(5, -8);

    System.out.println(p1.distance(p1, p2));

    System.out.println(p1.distance(p2));
  }
}
class FirstProgram {
    public static void main(String[] args) {

        Point p1 = new Point(5, 5);

        Point p2 = new Point(5, -8);

        System.out.println(distance(p1, p2));
    }


    public static double distance(Point p1, Point p2) {

        return Math.sqrt(Math.pow(p1.x - p2.x, 2.0) + Math.pow(p1.y - p2.y, 2.0));

    }
}
import java.util.*;

class Main {
  static class Point {
    int x, y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null || getClass() != obj.getClass())
        return false;
      Point point = (Point) obj;
      return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  static int countRectangles(List<Point> pts) {
    // Insert all the points in the set
    Set<Point> set = new HashSet<>(pts);

    // Two points + look up for other two
    int ans = 0;
    for (int i = 0; i < pts.size(); i++) {
      for (int j = i + 1; j < pts.size(); j++) {
        Point p1 = pts.get(i);
        Point p2 = pts.get(j);

        if (p2.x == p1.x || p2.y == p1.y)
          continue;

        Point p3 = new Point(p2.x, p1.y);
        Point p4 = new Point(p1.x, p2.y);

        if (set.contains(p3) && set.contains(p4)) {
          ans++;
        }
      }
    }
    return ans / 2;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Point> pts = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      Point p = new Point(x, y);
      pts.add(p);
    }
    System.out.println(countRectangles(pts));
    scanner.close();
  }
}

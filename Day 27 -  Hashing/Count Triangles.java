import java.util.*;

public class Main {
  static int countTriangles(List<Map.Entry<Integer, Integer>> points) {
    Map<Integer, Integer> freqX = new HashMap<>();
    Map<Integer, Integer> freqY = new HashMap<>();

    for (Map.Entry<Integer, Integer> entry : points) {
      int x = entry.getKey();
      int y = entry.getValue();

      freqX.put(x, freqX.getOrDefault(x, 0) + 1);
      freqY.put(y, freqY.getOrDefault(y, 0) + 1);
    }

    int ans = 0;
    for (Map.Entry<Integer, Integer> entry : points) {
      int x = entry.getKey();
      int y = entry.getValue();
      int fx = freqX.get(x);
      int fy = freqY.get(y);

      ans += (fx - 1) * (fy - 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Map.Entry<Integer, Integer>> points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      points.add(new AbstractMap.SimpleEntry<>(x, y));
    }
    System.out.println(countTriangles(points));
    scanner.close();
  }
}

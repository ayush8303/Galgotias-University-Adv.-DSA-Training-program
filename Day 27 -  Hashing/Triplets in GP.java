import java.util.*;

public class Main {
  public static int countTriplets(ArrayList<Integer> arr, int r) {
    int n = arr.size();
    HashMap<Integer, Integer> left = new HashMap<>();
    HashMap<Integer, Integer> right = new HashMap<>();
    for (int x : arr) {
      right.put(x, right.getOrDefault(x, 0) + 1);
    }
    int ans = 0;
    for (int j = 0; j < n; j++) {
      right.put(arr.get(j), right.get(arr.get(j)) - 1);

      if (arr.get(j) % r == 0) {
        int a = arr.get(j) / r;
        int b = arr.get(j);
        int c = arr.get(j) * r;
        ans += left.getOrDefault(a, 0) * right.getOrDefault(c, 0);
      }
      left.put(arr.get(j), left.getOrDefault(arr.get(j), 0) + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int r = scanner.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      arr.add(scanner.nextInt());
    }
    System.out.println(countTriplets(arr, r));
    scanner.close();
  }
}

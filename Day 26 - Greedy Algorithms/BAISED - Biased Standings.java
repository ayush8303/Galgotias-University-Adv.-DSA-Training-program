import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    while (t-- > 0) {
      int n = scanner.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        String name = scanner.next();
        int preferred = scanner.nextInt();
        a[i] = preferred;
      }
      Arrays.sort(a);
      long sum = 0;
      for (int i = 0; i < n; i++) {
        sum += Math.abs(a[i] - (i + 1));
      }
      System.out.println(sum);
    }
  }
}

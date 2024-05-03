import java.util.Scanner;

public class Main {
  static long solve(long[] a, long m) {
    int n = a.length;
    if (n > m) {
      return 0;
    }
    long ans = 1;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        long temp = Math.abs(a[i] - a[j]) % m;
        ans = ans % m;
        ans = (ans * temp) % m;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = 1;
    // t = scanner.nextInt();
    while (t-- > 0) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      long[] a = new long[n];
      for (int i = 0; i < n; i++) {
        a[i] = scanner.nextLong();
      }
      long result = solve(a, m);
      System.out.println(result);
    }
    scanner.close();
  }
}

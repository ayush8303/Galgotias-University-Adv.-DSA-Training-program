import java.util.*;

public class Main {
  public static void solve(Scanner scanner) {
    int n = scanner.nextInt();
    String s = scanner.next();
    for (int k = n; k > 0; k--) {
      int[] t = new int[n];
      int[] end = new int[n + 1];
      for (int i = 0; i < n; i++) {
        t[i] = s.charAt(i) - '0';
      }
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        cnt -= end[i];
        t[i] ^= (cnt & 1);
        if (t[i] == 0) {
          if (i + k <= n) {
            ++end[i + k];
            ++cnt;
            t[i] = 1;
          } else {
            break;
          }
        }
      }
      if (Arrays.stream(t).min().getAsInt() == 1) {
        System.out.println(k);
        return;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    while (t-- > 0) {
      solve(scanner);
    }
    scanner.close(); // Close the scanner after use
  }
}

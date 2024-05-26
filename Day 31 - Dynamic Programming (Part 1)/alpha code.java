import java.util.*;

public class Main {
  static String s;
  static long[] memo;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      s = scanner.next();
      if (s.equals("0")) {
        break;
      }
      memo = new long[s.length()];
      Arrays.fill(memo, -1);
      System.out.println(recur(0));
    }
    scanner.close();
  }

  static long recur(int i) {
    if (i == s.length()) {
      return 1;
    }
    if (memo[i] != -1) {
      return memo[i];
    }
    long ans = 0;
    if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
      ans += recur(i + 1);
    }
    if (i + 1 < s.length() && (s.charAt(i) == '1')) {
      ans += recur(i + 2);
    }
    if (i + 1 < s.length() && (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
      ans += recur(i + 2);
    }
    memo[i] = ans;
    return ans;
  }
}

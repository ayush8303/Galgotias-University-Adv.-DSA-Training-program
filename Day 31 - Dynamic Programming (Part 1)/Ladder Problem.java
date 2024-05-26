import java.util.Scanner;
import java.util.Arrays;

public class Main {

  // Recursive approach --> TC - O((n^k)*k)
  public static int countWays(int n, int k) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    int ans = 0;
    for (int jump = 1; jump <= k; jump++) {
      ans += countWays(n - jump, k);
    }
    return ans;
  }

  // Topdown DP TC - O((n*k)*k) SC - O(n) + O(n)
  public static int countWaysTD(int n, int k, int[] dp) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    if (dp[n] != -1) {
      return dp[n];
    }
    int ans = 0;
    for (int jump = 1; jump <= k; jump++) {
      ans += countWaysTD(n - jump, k, dp);
    }
    dp[n] = ans;
    return dp[n];
  }

  // Bottom up dp TC-O(n*k) SC - O(n)
  public static int countWaysBU(int n, int k) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int jump = 1; jump <= k; jump++) {
        if (i - jump >= 0) {
          dp[i] += dp[i - jump];
        }
      }
    }
    return dp[n];
  }

  // Tc - O(n)
  public static int countWaysOptimised(int n, int k) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      if ((i - (k + 1)) >= 0) {
        dp[i] = 2 * dp[i - 1] - dp[i - (k + 1)];
      } else {
        dp[i] = 2 * dp[i - 1];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int k = scanner.nextInt();

    System.out.println(countWays(n, k));

    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(countWaysTD(n, k, dp));

    System.out.println(countWaysBU(n, k));

    System.out.println(countWaysOptimised(n, k));

    scanner.close();
  }
}

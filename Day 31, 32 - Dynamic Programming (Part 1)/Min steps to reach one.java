import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    int[] dp = new int[n + 1];
    dp[1] = 0;

    for (int i = 2; i <= n; i++) {
      dp[i] = Integer.MAX_VALUE;
      dp[i] = Math.min(dp[i - 1], dp[i]); // N -> N-1
      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i / 2], dp[i]); // N -> N/2
      }
      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i / 3], dp[i]); // N -> N/3
      }
      dp[i]++; // +1 for current operation
    }

    System.out.println(dp[n]);
  }
}

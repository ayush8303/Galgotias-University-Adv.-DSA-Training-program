import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] dp = new int[n + 1]; // Note: size should be n + 1 to include dp[n]
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i / 2] + (i % 2);
      System.out.println(dp[i]);
    }
    scanner.close();
  }
}

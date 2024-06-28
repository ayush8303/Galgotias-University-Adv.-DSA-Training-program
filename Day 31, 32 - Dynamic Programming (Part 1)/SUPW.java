import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }

    if (n == 0) {
      System.out.println(0);
      return;
    } else if (n == 1) {
      System.out.println(arr[0]);
      return;
    } else if (n == 2) {
      System.out.println(Math.min(arr[0], arr[1]));
      return;
    }

    int[] dp = new int[n];
    dp[0] = arr[0];
    dp[1] = arr[1];
    dp[2] = arr[2];
    for (int i = 3; i < n; i++) {
      dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 3]) + arr[i];
    }

    int result = Math.min(Math.min(dp[n - 1], dp[n - 2]), dp[n - 3]);
    System.out.println(result);

    scanner.close();
  }
}

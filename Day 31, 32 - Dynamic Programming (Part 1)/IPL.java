import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    int sum = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
      sum += arr[i];
    }

    int[] dp = new int[n];
    dp[0] = arr[0];
    dp[1] = arr[1];
    dp[2] = arr[2];

    for (int i = 3; i < n; i++) {
      dp[i] = Math.min(dp[i - 1], Math.min(dp[i - 2], dp[i - 3])) + arr[i];
    }

    int result = sum - Math.min(dp[n - 1], Math.min(dp[n - 2], dp[n - 3]));

    System.out.println(result);

    sc.close();
  }
}

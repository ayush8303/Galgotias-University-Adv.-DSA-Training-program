import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    int[] dp = new int[k + 1];
    dp[0] = 0; // 0 -> losing position

    for (int i = 1; i <= k; i++) {
      dp[i] = 0; // assume losing position
      for (int j = 0; j < n; j++) {
        if (i - a[j] >= 0 && dp[i - a[j]] == 0) {
          dp[i] = 1; // found a winning move
          break;
        }
      }
    }

    if (dp[k] == 1) {
      System.out.println("First");
    } else {
      System.out.println("Second");
    }

    sc.close();
  }
}

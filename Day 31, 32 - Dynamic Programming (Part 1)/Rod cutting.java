import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static int[] memo;

  // TC - O(n*n)
  // ASC - O(n)
  public static int rodCutting(int n, int[] price) {
    if (n == 0)
      return 0;

    if (memo[n] != -1)
      return memo[n];

    int ans = 0;
    for (int i = 1; i <= n; i++) {
      ans = Math.max(ans, price[i] + rodCutting(n - i, price));
    }

    memo[n] = ans;
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] price = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      price[i] = sc.nextInt();
    }

    memo = new int[n + 1];
    Arrays.fill(memo, -1);

    System.out.println(rodCutting(n, price));
    sc.close();
  }
}

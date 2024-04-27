import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] h = new int[n];
    for (int i = 0; i < n; i++) {
      h[i] = scanner.nextInt();
    }
    int ans = 0;
    int[] cnt = new int[200001];
    for (int i = 0; i < n; i++) {
      cnt[0]++;
      cnt[h[i]]--;
    }
    for (int i = 1; i < 200001; i++) {
      cnt[i] += cnt[i - 1];
    }

    long sum = 0;
    for (int i = 200000; i >= 0; i--) {
      if (cnt[i] == n) {
        ans += (sum > 0) ? 1 : 0;
        break;
      }
      if (sum + cnt[i] > k) {
        ans++;
        sum = cnt[i];
        continue;
      }
      sum += cnt[i];
    }
    System.out.println(ans);
  }
}

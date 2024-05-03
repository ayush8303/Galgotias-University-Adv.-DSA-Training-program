import java.util.Scanner;

public class Main {
  static final int N = 1000000 + 1;

  static void primeSieve(int[] sieve) {
    sieve[0] = sieve[1] = 0;

    for (int p = 2; p < N; p++) {
      if (sieve[p] == 1) {
        for (long j = (long) p * p; j < N; j += p) {
          sieve[(int) j] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] sieve = new int[N];
    for (int i = 0; i < N; i++) {
      sieve[i] = 1;
    }
    primeSieve(sieve);
    int ans = 0;
    for (int i = 3; i <= n - 2; i++) {
      if (sieve[i] == 1 && sieve[i + 2] == 1) {
        ans++;
      }
    }
    System.out.println(ans);
    scanner.close();
  }
}

import java.util.Scanner;

public class Main {
  static void primeSieve(int[] sieve) {
    int N = sieve.length;
    // mark 1 and 0 as non-prime
    sieve[0] = sieve[1] = 0;

    for (long p = 2; p < N; p++) {
      if (sieve[(int) p] == 1) {
        for (long j = p * p; j < N; j += p) {
          // marking j as non-prime
          sieve[(int) j] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] sieve = new int[1000000 + 1];
    for (int i = 0; i < sieve.length; i++) {
      sieve[i] = 1;
    }
    primeSieve(sieve);
    int cnt = 0;
    for (int i = 0; i <= n; i++) {
      if (sieve[i] == 1) {
        cnt++;
      }
    }
    System.out.println(cnt);
    scanner.close();
  }
}

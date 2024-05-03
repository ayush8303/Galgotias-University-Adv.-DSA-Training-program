import java.util.Scanner;
import java.util.Vector;

public class Main {
  // brute force - TC - O(n)
  static void factorise(int n) {
    for (int i = 2; i <= n; i++) {
      if (n % i == 0) {
        int cnt = 0;
        while (n % i == 0) {
          n = n / i;
          cnt++;
        }
        System.out.print(i + "^" + cnt + " ");
      }
    }
  }

  // Optimised - TC - O(n^(1/2))
  static void optimised(int n) {
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        int cnt = 0;
        while (n % i == 0) {
          n = n / i;
          cnt++;
        }
        System.out.print(i + "^" + cnt + " ");
      }
    }
    if (n != 1) {
      System.out.print(n + "^" + 1 + " ");
    }
  }

  // using prime sieve - TC - O(nloglogn)
  static void updatedPrimeSieve(Vector<Integer> sieve) {
    int N = sieve.size();
    for (int p = 2; p < N; p++) {
      if (sieve.get(p) == 1) {
        sieve.set(p, p);
        for (int j = p * p; j < N; j += p) {
          if (sieve.get(j) == 1)
            sieve.set(j, p);
        }
      }
    }
  }

  static void factoriseUsingSieve(int n, Vector<Integer> sieve) {
    while (n > 1) {
      int fact = sieve.get(n);
      while (n % fact == 0) {
        System.out.print(fact + " ");
        n = n / fact;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    // factorise(n);
    // optimised(n);
    Vector<Integer> sieve = new Vector<>(100);
    for (int i = 0; i < 100; i++) {
      sieve.add(1);
    }
    updatedPrimeSieve(sieve);
    factoriseUsingSieve(n, sieve);
    scanner.close();
  }
}

import java.util.Scanner;

public class Main {
  static final int MOD = (int) 1e9 + 7;

  static int addm(int x, int y) {
    return ((x % MOD) + (y % MOD)) % MOD;
  }

  static int subm(int x, int y) {
    return ((x % MOD) - (y % MOD) + MOD) % MOD;
  }

  static int mulm(long x, long y) {
    return (int) ((x % MOD) * (y % MOD)) % MOD;
  }

  static int power(int x, int n) {
    int res = 1;
    while (n > 0) {
      int lastBit = (n & 1);
      if (lastBit != 0)
        res = mulm(res, x);
      n >>= 1;
      x = mulm(x, x);
    }
    return res;
  }

  static int inv(int x) {
    return power(x, MOD - 2);
  }

  static int divm(int x, int y) {
    return mulm(x, inv(y));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    System.out.println(divm(x, y));
    scanner.close();
  }
}

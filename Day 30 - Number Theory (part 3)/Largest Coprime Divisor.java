import java.util.Scanner;

public class Main {
  static int gcd(int a, int b) {
    if (a < b) {
      int temp = a;
      a = b;
      b = temp;
    }
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  static int solve(int a, int b) {
    while (gcd(a, b) != 1) {
      a /= gcd(a, b);
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    System.out.println(solve(a, b));
    scanner.close();
  }
}

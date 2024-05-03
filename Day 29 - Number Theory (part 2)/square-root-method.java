import java.util.Scanner;

public class Main {
  // square root method
  static boolean isPrime(int n) {
    if (n <= 1)
      return false;
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(isPrime(n) ? "true" : "false");
    scanner.close();
  }
}

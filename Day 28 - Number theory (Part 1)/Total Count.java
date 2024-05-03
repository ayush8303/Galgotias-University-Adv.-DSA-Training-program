import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int[] primes = { 2, 3, 5 };
    int n = primes.length;
    int ans = 0;
    for (int i = 1; i < (1 << n); i++) {
      int lcm = 1;
      for (int j = 0; j < n; j++) {
        int bit = i & (1 << j);
        if (bit > 0) {
          lcm *= primes[j];
        }
      }
      int curContr = m / lcm;
      int noOfSetBits = Integer.bitCount(i);
      if (noOfSetBits % 2 == 0) {
        ans -= curContr;
      } else {
        ans += curContr;
      }
    }
    System.out.println(ans);
    scanner.close();
  }
}

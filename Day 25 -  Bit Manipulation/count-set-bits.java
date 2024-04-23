import java.util.Scanner;

public class Main {

  static int cntUsingRightShift(int n) {
    int cnt = 0;
    while (n > 0) {
      int LSB = n & 1;
      if (LSB == 1)
        cnt++;
      n >>= 1; // n = n >> 1
    }
    return cnt;
    // TC - O(logn)
  }

  static int optimised(int n) {
    int cnt = 0;
    while (n > 0) {
      n = n & (n - 1);
      cnt++;
    }
    return cnt;
    // TC - O(no. of set bits)
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    // System.out.println(cntUsingRightShift(n));
    System.out.println(optimised(n));

    scanner.close();
  }
}

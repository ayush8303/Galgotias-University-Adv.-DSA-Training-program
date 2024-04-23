public class Main {
  // Tc -> O(logn)
  static int power(int x, int n) {
    int ans = 1;
    while (n > 0) {
      int lastBit = n & 1;
      if (lastBit > 0) {
        ans *= x;
      }
      n >>= 1;
      x *= x;
    }
    return ans;
  }

  public static void main(String[] args) {
    int x = 2, n = 10;
    System.out.println(power(x, n));
  }
}

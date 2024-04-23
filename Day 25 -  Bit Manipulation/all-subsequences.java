import java.util.Scanner;

public class Main {

  static void curSubsequence(int number, String s) {
    int j = 0; // index in s
    if (number == 0) {
      System.out.println(""); // empty subsequence
      return;
    }
    while (number > 0) {
      int last_bit = number & 1;
      if (last_bit > 0) {
        System.out.print(s.charAt(j));
      }
      j++;
      number >>= 1;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();

    int n = s.length();

    // 0 --> (2^n) - 1
    for (int i = 0; i < (1 << n); i++) {
      curSubsequence(i, s);
    }
  }
}

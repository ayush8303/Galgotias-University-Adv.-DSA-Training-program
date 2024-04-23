import java.util.Scanner;

public class Main {

  public static int clearBits(int n, int i, int j) {
    int a = (~0) << (j + 1);
    int b = (1 << i) - 1;

    int mask = a | b;

    return n & mask;
  }

  public static int replaceBits(int n, int m, int i, int j) {
    n = clearBits(n, i, j);

    int mask = (m << i);
    return n | mask;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n, m, i, j;
    n = scanner.nextInt();
    m = scanner.nextInt();
    i = scanner.nextInt();
    j = scanner.nextInt();

    n = replaceBits(n, m, i, j);
    System.out.println(n);
  }
}

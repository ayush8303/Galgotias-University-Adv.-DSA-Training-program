import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();
    while (t-- > 0) {
      int w = scanner.nextInt();
      int h = scanner.nextInt();
      int n = scanner.nextInt();

      int[] x = new int[n + 2];
      int[] y = new int[n + 2];
      x[0] = 0;
      x[n + 1] = w + 1;
      y[0] = 0;
      y[n + 1] = h + 1;

      for (int i = 1; i <= n; i++) {
        x[i] = scanner.nextInt();
        y[i] = scanner.nextInt();
      }

      Arrays.sort(x);
      Arrays.sort(y);

      int maxX = 0;
      int maxY = 0;
      for (int i = 1; i <= (n + 1); i++) {
        int no_of_cells_in_x = x[i] - x[i - 1] - 1;
        int no_of_cells_in_y = y[i] - y[i - 1] - 1;
        maxX = Math.max(maxX, no_of_cells_in_x);
        maxY = Math.max(maxY, no_of_cells_in_y);
      }

      System.out.println(maxX * maxY);
    }
  }
}

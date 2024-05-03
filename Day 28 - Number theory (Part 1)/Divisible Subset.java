import java.util.*;

class Codechef {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // number of test cases
    while (T > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int[] indices = new int[n];
      Arrays.fill(indices, -1);
      long sum = 0;
      int start = 0, end = 0;
      for (int i = 0; i < n; i++) {
        sum += arr[i];
        long val = sum % n;
        if (val == 0) {
          System.out.println(i + 1);
          for (int k = 0; k <= i; k++) {
            System.out.print((k + 1) + " ");
          }
          System.out.println();
          break;
        } else {
          if (indices[(int) val] != -1) {
            int j = indices[(int) val];
            System.out.println(i - j); // size of subset/subarray
            for (int k = j + 1; k <= i; k++) { // element of subarray
              System.out.print((k + 1) + " ");
            }
            System.out.println();
            break;
          } else {
            indices[(int) val] = i;
          }
        }
      }
      T--;
    }
    sc.close();
  }
}

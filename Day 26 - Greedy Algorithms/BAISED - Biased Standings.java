import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
    int zz = Integer.parseInt(file.readLine());
    for (int z = 0; z < zz; z++) {
      file.readLine();
      int N = Integer.parseInt(file.readLine());
      int[] ints = new int[N];
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(file.readLine());
        st.nextToken();
        ints[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(ints);
      long bad = 0;
      for (int i = 0; i < N; i++) {
        bad += (Math.abs(i + 1 - ints[i]));
      }
      System.out.println(bad);
    }

  }
}
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      List<Pair> activities = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        activities.add(new Pair(start, end));
      }
      Collections.sort(activities);

      int ans = 1;
      int currentEnd = activities.get(0).end;
      for (int i = 1; i < n; i++) {
        if (currentEnd <= activities.get(i).start) {
          ans++;
          currentEnd = activities.get(i).end;
        }
      }
      bw.write(ans + "\n");
    }

    br.close();
    bw.close();
  }

  static class Pair implements Comparable<Pair> {
    int start;
    int end;

    public Pair(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
      if (this.end == o.end) {
        return this.start - o.start;
      }
      return this.end - o.end;
    }
  }
}

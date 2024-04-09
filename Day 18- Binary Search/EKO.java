import java.io.*;

public class Main {
    static final int N = 1000010;
    static long[] trees = new long[N];
    static long n, m;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader for faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Long.parseLong(inputs[0]);
        m = Long.parseLong(inputs[1]);
        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(inputs[i]);
        }
        long low = 0, high = 1_000_000_000;
        long ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isWoodSufficient(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Use PrintWriter for faster output
        PrintWriter out = new PrintWriter(System.out);
        out.println(ans);
        out.flush();
    }

    private static boolean isWoodSufficient(long height) {
        long wood = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i] > height) {
                wood += (trees[i] - height);
            }
        }
        return wood >= m;
    }
}

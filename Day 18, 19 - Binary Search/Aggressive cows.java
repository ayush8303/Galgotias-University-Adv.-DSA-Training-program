import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    static int n, cows;
    static int[] positions;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        while (t-- > 0) {
            n = scanner.nextInt(); // Number of stalls
            cows = scanner.nextInt(); // Number of cows
            positions = new int[n];

            for (int i = 0; i < n; i++) {
                positions[i] = scanner.nextInt(); // Position of each stall
            }

            Arrays.sort(positions); // Sorting the stall positions
            
            long lo = 0, hi = 1_000_000_000; // Setting high value considering the constraints
            long ans = 0;
            while (lo <= hi) {
                long mid = (lo + hi) / 2;
                if (canPlaceCows(mid)) {
                    ans = mid;
                    lo = mid + 1; // Try for a bigger distance
                } else {
                    hi = mid - 1; // Try for a smaller distance
                }
            }
            System.out.println(ans);
        }
        scanner.close();
    }

    private static boolean canPlaceCows(long minDist) {
        long last_pos = -1;
        int cows_ct = cows;
        for (int i = 0; i < n; i++) {
            if (positions[i] - last_pos >= minDist || last_pos == -1) {
                cows_ct--;
                last_pos = positions[i];
            }
            if (cows_ct == 0) break;
        }
        return cows_ct == 0;
    }
}

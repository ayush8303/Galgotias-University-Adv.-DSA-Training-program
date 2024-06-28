import java.util.Scanner;

public class Main {

    static int solve(int n, int k, int[][] grid) {
        int l = 0, r = (int) 1e9, mid, ans = -1;
        int x = (k * k) / 2;
        x++;
        while (l <= r) {
            mid = (l + r) / 2;
            int[][] pre = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > mid) {
                        pre[i][j] = 1;
                    }
                    if (i - 1 >= 0) {
                        pre[i][j] += pre[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        pre[i][j] += pre[i][j - 1];
                    }
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        pre[i][j] -= pre[i - 1][j - 1];
                    }
                }
            }
            int flag = 0;
            for (int i = k - 1; i < n; i++) {
                for (int j = k - 1; j < n; j++) {
                    int val = pre[i][j];
                    if (i - k >= 0) {
                        val -= pre[i - k][j];
                    }
                    if (j - k >= 0) {
                        val -= pre[i][j - k];
                    }
                    if (i - k >= 0 && j - k >= 0) {
                        val += pre[i - k][j - k];
                    }
                    if (val < x) {
                        flag = 1;
                    }
                }
            }
            if (flag == 1) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(n, k, grid));
    }
}

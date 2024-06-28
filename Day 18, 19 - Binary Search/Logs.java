import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        int l = 1, r = (int) 1e9, mid = 0, ans = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (arr[i] - 1) / mid;
            }
            if (sum <= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }
}

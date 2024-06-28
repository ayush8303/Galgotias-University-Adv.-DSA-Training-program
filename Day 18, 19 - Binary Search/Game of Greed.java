import java.util.Scanner;

public class Main {
    // Function to check if it is possible to divide the array into k parts with at least 'min_partition' sum each
    static boolean divideAmongK(int[] arr, int n, int k, int min_partition) {
        int partitions = 0;
        int current_sum = 0;
        for (int i = 0; i < n; i++) {
            // If adding the current element to 'current_sum' exceeds 'min_partition', a new partition is created
            if (current_sum + arr[i] >= min_partition) {
                partitions++;
                current_sum = 0;
            } else {
                current_sum += arr[i];
            }
        }
        // Check if the number of partitions is at least k
        return partitions >= k;
    }

    // Function to find the maximum minimum partition sum
    static long k_partition(int n, int[] arr, int k) {
        long low = 1, high = 1e8;
        long ans = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            boolean isPossible = divideAmongK(arr, n, k, (int) mid);
            if (isPossible) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(k_partition(n, arr, k));
        scanner.close();
    }
}

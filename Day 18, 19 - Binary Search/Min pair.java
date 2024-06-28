import java.util.*;

public class Main {
    
    static int minPair(List<Integer> arr1, List<Integer> arr2) {
        // sort one array
        Collections.sort(arr2);

        int ans = Integer.MAX_VALUE; // min abs diff

        // iterate over 1 array and look for closest elements in the second array
        for (int x : arr1) {
            int lb = Collections.binarySearch(arr2, x);
            int id1 = (lb >= 0) ? lb : -lb - 1;
            int id2 = id1 - 1;
            if (id1 < arr2.size()) {
                ans = Math.min(ans, Math.abs(x - arr2.get(id1)));
            }
            if (id2 >= 0 && id2 < arr2.size()) {
                ans = Math.min(ans, Math.abs(x - arr2.get(id2)));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arr1.add(x);
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            arr2.add(x);
        }
        System.out.println(minPair(arr1, arr2));
        // TC - O(mlogm + nlogm)
    }
}

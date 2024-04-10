import java.util.*;

public class Main {

    static List<List<Integer>> powerSet = new ArrayList<>();

    public static void generate(List<Integer> nums, int i, List<Integer> curSubset) {
        if (i == nums.size()) {
            powerSet.add(new ArrayList<>(curSubset));
            return;
        }
        // Include ith element
        curSubset.add(nums.get(i));
        generate(nums, i + 1, curSubset);
        curSubset.remove(curSubset.size() - 1);

        // Exclude ith element
        generate(nums, i + 1, curSubset);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }
        List<Integer> curSubset = new ArrayList<>();
        generate(nums, 0, curSubset);

        Collections.sort(powerSet, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                int size = Math.min(a.size(), b.size());
                for (int i = 0; i < size; i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0) return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });

        for (List<Integer> subset : powerSet) {
            for (int x : subset) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<Pair> elements = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                elements.add(new Pair(num, i));
            }
        }

        Collections.sort(elements, (a, b) -> a.val - b.val);

        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, right = 0;
        int[] result = new int[2];
        int minRange = Integer.MAX_VALUE;
        while (right < elements.size()) {
            Pair current = elements.get(right);
            count.put(current.idx, count.getOrDefault(current.idx, 0) + 1);
            
            while (count.size() == nums.size()) {
                if (minRange > elements.get(right).val - elements.get(left).val) {
                    minRange = elements.get(right).val - elements.get(left).val;
                    result[0] = elements.get(left).val;
                    result[1] = elements.get(right).val;
                }
                Pair leftMost = elements.get(left);
                count.put(leftMost.idx, count.get(leftMost.idx) - 1);
                if (count.get(leftMost.idx) == 0) {
                    count.remove(leftMost.idx);
                }
                left++;
            }
            right++;
        }
        return result;
    }

    static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
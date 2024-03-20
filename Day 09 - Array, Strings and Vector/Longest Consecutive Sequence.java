class Solution {
    public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int x : nums) {
			set.add(x);
		}
		int ans = 0;
		for (int element : set) {
			int parent = element - 1;
			if (!set.contains(parent)) {
				int cnt = 1;
				int next_no = element + 1;
				while (set.contains(next_no)) {
					cnt++;
					next_no++;
				}
				ans = Math.max(ans, cnt);
			}
		}
		return ans;
	}
}
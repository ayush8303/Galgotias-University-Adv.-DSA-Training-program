class Solution {
   public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int i = 0, j = 0;
		int max_window_len = 0;
		while (j < s.length()) {
			char ch = s.charAt(j);
			if (map.containsKey(ch) && map.get(ch) >= i) {
				i = map.get(ch) + 1;
			}
			map.put(ch, j);
			max_window_len = Math.max(max_window_len, j - i + 1);
			j++;
		}
		return max_window_len;
	}
}
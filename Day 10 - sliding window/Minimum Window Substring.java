class Solution {
    public String minWindow(String s, String t) {
		int m = s.length();
		int n = t.length();

		int[] freq_pattern = new int[128]; // frequency of string t
		for (int i = 0; i < n; i++) {
			char ch = t.charAt(i);
			freq_pattern[ch]++;
		}

		int[] freq_curr = new int[128];
		int i = 0;
		int cnt = 0; // no. of matched characters
		int min_so_far = m+1;
		int start = -1;
		for (int j = 0; j < m; j++) {
			char ch = s.charAt(j);
			freq_curr[ch]++;
			if (freq_curr[ch] <= freq_pattern[ch]) {
				cnt++;
			}
			if (cnt == n) {
				while (freq_curr[s.charAt(i)] > freq_pattern[s.charAt(i)]) {
					freq_curr[s.charAt(i)]--;
					i++;
				}
				int cur_window_length = j - i + 1;
				if (cur_window_length < min_so_far) {
					start = i;
					min_so_far = cur_window_length;
				}
			}
		}
		if (start == -1) return "";
		return s.substring(start, start + min_so_far);
	}
}
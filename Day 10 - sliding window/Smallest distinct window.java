class Solution {
    final int MAX_CHARS = 128;
	public int findSubString( String str) {
		int n = str.length();

		boolean[] visited = new boolean[MAX_CHARS];
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[str.charAt(i)]) {
				visited[str.charAt(i)] = true;
				total++;
			}
		}
		int curr = 0;
		int start = 0;
		int ans = n;
		int[] curr_count = new int[MAX_CHARS];
		for (int end = 0; end < n; end++) {
			int count = curr_count[str.charAt(end)];
			if (count == 0) {
				curr++;
			}
			curr_count[str.charAt(end)]++; // frequency inc
			if (curr == total) {
				while (curr_count[str.charAt(start)] > 1) {
				
					curr_count[str.charAt(start)]--;
						start++;
				}
				ans = Math.min(ans, end - start + 1);
			}
		}
		return ans;
	}

}
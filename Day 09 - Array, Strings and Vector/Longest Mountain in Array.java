class Solution {
    public int longestMountain(int[] arr) {
		int N = arr.length;
		int[] pref = new int[N];
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] < arr[i]) {
				pref[i] = pref[i - 1] + 1;
			}
		}
		int[] suff = new int[N];
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1]) {
				suff[i] = suff[i + 1] + 1;
			}
		}
		int ans = 0;
		for (int i = 1; i < N - 1; i++) {
			int left = pref[i];
			int right = suff[i];
			if (left > 0 && right > 0)
				ans = Math.max(ans, left + right + 1);
		}
		return ans;
	}
}
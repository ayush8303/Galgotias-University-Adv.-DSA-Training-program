class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
		long ans = 0;

		// first window
		long cur = 0;
		for (int i = 0; i < K; i++) {
			cur += Arr.get(i);
		}
		ans = cur;
		for (int i = K; i < N; i++) {
			cur += Arr.get(i);
			cur -= Arr.get(i - K);
			ans = Math.max(ans, cur);
		}
		return ans;
	}
}
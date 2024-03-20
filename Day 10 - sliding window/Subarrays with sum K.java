class Solution
{
    static int findSubArraySum(int Arr[], int N, int k) {
		// code here
		HashMap<Integer, Integer> mp = new HashMap<>();
		int res = 0;
		int cur = 0;
		for (int i = 0; i < N; i++) {
			cur += Arr[i];
			if (cur == k) {
				res++;
			}
			if (mp.containsKey(cur - k)) {
				res += mp.get(cur - k);
			}
			int count = 0;
			if (mp.containsKey(cur)) {
				count = mp.get(cur);
			}
			mp.put(cur, count + 1);
		}
		return res;
	}
}
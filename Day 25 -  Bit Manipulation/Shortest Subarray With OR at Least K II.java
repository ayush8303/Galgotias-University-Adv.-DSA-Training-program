class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int orVal = 0;
        int[] bitCount = new int[30];
        Arrays.fill(bitCount, 0);

        for (int j = 0, i = 0; i < nums.length; ++i) {
            orVal |= nums[i]; // Performing bitwise OR operation
            for (int t = 0; t < 30; ++t) {
                bitCount[t] += (nums[i] & (1 << t)) != 0 ? 1 : 0; // Updating bitCount
            }
            if (orVal < k)
                continue;
            for (; j <= i && orVal >= k; ++j) {
                for (int t = 0; t < 30; ++t) {
                    bitCount[t] -= (nums[j] & (1 << t)) != 0 ? 1 : 0; // Nullifying OR operation
                    if (bitCount[t] == 0)
                        orVal &= ~(1 << t);
                }
                ans = Math.min(ans, i - j + 1);
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
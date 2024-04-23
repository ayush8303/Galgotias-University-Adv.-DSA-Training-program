class Solution {
public:
    int minimumSubarrayLength(vector<int>& nums, int k) {
        int ans = INT_MAX;
        int orVal = 0;
        vector<int> bitCount(30, 0);

        for (int j = 0, i = 0; i < nums.size(); ++i) {
            orVal |= nums[i]; // Performing bitwise OR operation
            for (int t = 0; t < 30; ++t) {
                bitCount[t] += (nums[i] & (1 << t)) ? 1 : 0; // Updating bitCount
            }
            if (orVal < k)
                continue;
            for (; j <= i && orVal >= k; ++j) {
                for (int t = 0; t < 30; ++t) {
                    bitCount[t] -= (nums[j] & (1 << t)) ? 1 : 0; // Nullifying OR operation
                    if (bitCount[t] == 0)
                        orVal &= ~(1 << t);
                }
                ans = min(ans, i - j + 1);
            }
        }
        return (ans == INT_MAX) ? -1 : ans;
    }
};
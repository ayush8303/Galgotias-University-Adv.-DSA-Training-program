class Solution
{
public:
  int longestSubarray(vector<int> &nums)
  {
    int n = nums.size();
    int ans = 0;
    int cnt = 0; // no. of zeros in curr window
    int i = 0;
    // window [i....j]
    for (int j = 0; j < n; j++)
    {
      // expand
      if (nums[j] == 0)
        cnt++;
      while (cnt > 1)
      {
        if (nums[i] == 0)
          cnt--;
        i++;
      }
      ans = max(ans, j - i);
    }
    return ans;
  }
};

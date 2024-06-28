class Solution
{
public:
  int countSubstrings(string s)
  {
    int n = s.length();
    vector<vector<int>> dp(n, vector<int>(n, 0));
    for (int i = 0; i < n; i++)
      dp[i][i] = 1;
    for (int i = n - 1; i >= 0; i--)
    {
      for (int j = i; j < n; j++)
      {
        if (i == j)
          continue;
        if ((i + 1) == j)
          dp[i][j] = (s[i] == s[j]);
        else if (s[i] == s[j])
          dp[i][j] = dp[i + 1][j - 1];
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {
        if (dp[i][j])
          ans++;
      }
    }
    return ans;
  }
};
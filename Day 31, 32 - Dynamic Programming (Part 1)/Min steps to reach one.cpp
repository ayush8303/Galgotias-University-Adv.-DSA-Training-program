#include <bits/stdc++.h>
using namespace std;

int main()
{
  int n;
  cin >> n;

  int dp[n + 1];
  dp[1] = 0;
  for (int i = 2; i <= n; i++)
  {
    dp[i] = INT_MAX;
    dp[i] = min(dp[i - 1], dp[i]); // N -> N-1
    if (i % 2 == 0)
      dp[i] = min(dp[i / 2], dp[i]); // N -> N/2
    if (i % 3 == 0)
      dp[i] = min(dp[i / 3], dp[i]); // N -> N/3

    dp[i]++; // +1 for current operation
  }
  cout << dp[n];

  return 0;
}
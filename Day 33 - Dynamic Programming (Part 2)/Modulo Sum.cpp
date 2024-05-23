#include <bits/stdc++.h>
using namespace std;
#define int int64_t
#define endl "\n"

void solve()
{
  int n, m;
  cin >> n >> m;
  int arr[n];
  for (int i = 0; i < n; i++)
    cin >> arr[i];
  if (n >= m)
  {
    cout << "YES";
  }
  else
  {
    vector<vector<int>> dp(n, vector<int>(m, 0));
    dp[0][arr[0] % m] = 1;
    for (int i = 1; i < n; i++)
    {
      for (int j = 0; j < m; j++)
      {
        dp[i][j] = dp[i][j] | dp[i - 1][j];
        if (dp[i - 1][j])
        {
          dp[i][(j + arr[i]) % m] = 1;
        }
      }
      dp[i][arr[i] % m] = 1;
    }
    if (dp[n - 1][0])
      cout << "YES";
    else
      cout << "NO";
  }
}

int32_t main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  // cin>>t;
  while (t--)
    solve();

  return 0;
}
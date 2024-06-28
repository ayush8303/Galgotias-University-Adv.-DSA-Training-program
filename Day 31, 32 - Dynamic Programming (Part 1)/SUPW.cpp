#include <bits/stdc++.h>
using namespace std;

int main()
{
  int n;
  cin >> n;
  int arr[n];
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }
  int dp[n];
  dp[0] = arr[0];
  dp[1] = arr[1];
  dp[2] = arr[2];
  for (int i = 3; i < n; i++)
  {
    dp[i] = min({dp[i - 1], dp[i - 2], dp[i - 3]}) + arr[i];
  }
  cout << min({dp[n - 1], dp[n - 2], dp[n - 3]});

  return 0;
}